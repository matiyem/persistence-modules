package com.example.namingstrategy;

import com.example.namingStrategy.Person;
import com.example.namingStrategy.PersonRepository;
import org.hibernate.exception.SQLGrammarException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.TestDatabaseAutoConfiguration;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.TestPropertySource;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DataJpaTest(excludeAutoConfiguration = TestDatabaseAutoConfiguration.class)
@TestPropertySource("quoted-upper-case-naming-strategy.properties")
class QuotedUpperCaseNamingStrategyH2IntegrationTest {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private PersonRepository personRepository;

    @BeforeEach
    void insertPeople() {
        personRepository.saveAll(Arrays.asList(
          new Person(1L, "John", "Doe"),
          new Person(2L, "Jane", "Doe"),
          new Person(3L, "Ted", "Mosby")
        ));
    }

    @ParameterizedTest
    @ValueSource(strings = {"person", "PERSON", "Person"})
    void givenPeopleAndUpperCaseNamingStrategy_whenQueryPersonUnquoted_thenException(String tableName) {
        Query query = entityManager.createNativeQuery("select * from " + tableName);
        //در اینجا در حال استفاده از identifire upper case| هستیم و همچنین نحوه ارسال نام تیبل اشتباه است و در نتیجه به خطای ExceptionSqlGrammer بر میخوریم
        // Expected result
        List<Person> result = (List<Person>) query.getResultStream()
                //میتوانیم به جای map از forEach هم استفاده کنیم استفاده از map ترجیح داده میشود
          .map(this::fromDatabase)
          .collect(Collectors.toList());

        assertThat(result).isNotEmpty();
    }

    @Test
    void givenPeopleAndUpperCaseNamingStrategy_whenQueryPersonQuotedUpperCase_thenResult() {
        //این تست بدرستی پاس میشود چون هم نام جدول درست است که بصورت upper case ارسال شده است هم اینکه نحوه ارسال آن درست است
        Query query = entityManager.createNativeQuery("select * from \"PERSON\"");

        // Expected result
        List<Person> result = (List<Person>) query.getResultStream()
          .map(this::fromDatabase)
          .collect(Collectors.toList());

        assertThat(result).isNotEmpty();
    }

    @Test
    void givenPeopleAndUpperCaseNamingStrategy_whenQueryPersonQuotedLowerCase_thenException() {
        //در اینجا هم در حال idetifire upper case هستیم ولی نام جدول بصورت lower case ارسال میشود که در نتیجه به خطای sql grammer بر میخوریم
        Query query = entityManager.createNativeQuery("select * from \"person\"");

        // Expected result
        assertThrows(SQLGrammarException.class, query::getResultStream);
    }

    public Person fromDatabase(Object databaseRow) {
        Object[] typedDatabaseRow = (Object[]) databaseRow;

        return new Person(
          ((BigInteger) typedDatabaseRow[0]).longValue(),
          (String) typedDatabaseRow[1],
          (String) typedDatabaseRow[2]
        );
    }
}
