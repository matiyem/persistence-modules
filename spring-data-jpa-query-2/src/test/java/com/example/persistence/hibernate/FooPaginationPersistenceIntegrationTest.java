package com.example.persistence.hibernate;

import com.example.persistence.model.Foo;
import com.example.persistence.service.IFooService;
import com.example.spring.config.PersistenceTestConfig;
import com.google.common.collect.Lists;
import org.hibernate.*;
import org.hibernate.criterion.Projections;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import java.util.List;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.lessThan;
import static org.junit.Assert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {PersistenceTestConfig.class}, loader = AnnotationConfigContextLoader.class)
public class FooPaginationPersistenceIntegrationTest {

    @Autowired
    @Qualifier("fooHibernateService")//اینجا اسم متد را گذاشتم اگر نذارم ارور میده
    private IFooService fooService;

    @Autowired
    private SessionFactory sessionFactory;

    private Session session;

    // tests

    @Before
    public final void before() {
        final int minimalNumberOfEntities = 25;
        if (fooService.findAll().size() <= minimalNumberOfEntities) {
            for (int i = 0; i < minimalNumberOfEntities; i++) {
                fooService.create(new Foo(randomAlphabetic(6)));
            }
        }

        session = sessionFactory.openSession();
    }

    @After
    public final void after() {
        session.close();
    }

    // tests

    @Test
    public final void whenContextIsBootstrapped_thenNoExceptions() {
        //
    }

    @SuppressWarnings("unchecked")
    @Test
    public final void whenRetrievingPaginatedEntities_thenCorrectSize() {
        final int pageNumber = 1;
        final int pageSize = 10;

        final Query query = session.createQuery("From Foo");
        query.setFirstResult((pageNumber - 1) * pageSize);
        query.setMaxResults(pageSize);
        final List<Foo> fooList = query.list();

        assertThat(fooList, hasSize(pageSize));
    }

    @SuppressWarnings("unchecked")
    @Test
    public final void whenRetrievingAllPages_thenCorrect() {
        int pageNumber = 1;
        final int pageSize = 10;

        final String countQ = "Select count (f.id) from Foo f";
        final Query countQuery = session.createQuery(countQ);
        //برای گرفتن count است
        final Long countResult = (Long) countQuery.uniqueResult();

        final List<Foo> fooList = Lists.newArrayList();
        int totalEntities = 0;
        final Query query = session.createQuery("From Foo");
        while (totalEntities < countResult) {
            query.setFirstResult((pageNumber - 1) * pageSize);
            query.setMaxResults(pageSize);
            fooList.addAll(query.list());
            totalEntities = fooList.size();
            pageNumber++;
        }
    }

    @SuppressWarnings("unchecked")
    @Test
    public final void whenRetrievingLastPage_thenCorrectSize() {
        //در این قسمت شماره صفحه آخر محاسبه میشود
        final int pageSize = 10;

        final String countQ = "Select count (f.id) from Foo f";
        final Query countQuery = session.createQuery(countQ);
        final Long countResults = (Long) countQuery.uniqueResult();
        final int lastPageNumber = (int) (Math.ceil(countResults / pageSize));

        final Query selectQuery = session.createQuery("From Foo");
        selectQuery.setFirstResult((lastPageNumber - 1) * pageSize);
        selectQuery.setMaxResults(pageSize);
        final List<Foo> lastPage = selectQuery.list();

        assertThat(lastPage, hasSize(lessThan(pageSize + 1)));
    }

    // testing - scrollable

    @Test
    public final void givenUsingTheScrollableApi_whenRetrievingPaginatedData_thenCorrect() {
        final int pageSize = 10;
        final String hql = "FROM Foo f order by f.name";
        final Query query = session.createQuery(hql);
        //از ScrollableResults برای دیتا های بزرگ استفاده میششود
        //scroll mode دارای سه حالت به شرح زیر است:
        //forward only یعنی فقط حرکت روبه جلو داشته باشد
        //SCROLL_SENSITIVE نسبت به تغییر داده های اساسی حساس است
        //SCROLL_INSENSITIVE نسبت به تغییر داده های اساسی حساس نیست
        final ScrollableResults resultScroll = query.scroll(ScrollMode.FORWARD_ONLY);
        //این روش نه تنها از نظر زمان مقرون به صرفه است (فقط یک تماس با پایگاه داده) ، بلکه به کاربر اجازه می دهد
        // تا به تعداد کل مجموعه نتایج بدون پرس و جو اضافی دسترسی پیدا کند:
        // resultScroll.last();
        // final int totalResults = resultScroll.getRowNumber() + 1;


        //کوییری به ازای هر صفحه صدا زده میشود
        resultScroll.first();
        resultScroll.scroll(0);
        final List<Foo> fooPage = Lists.newArrayList();
        int i = 0;
        while (pageSize > i++) {
            fooPage.add((Foo) resultScroll.get(0));
            if (!resultScroll.next()) {
                break;
            }
        }

        assertThat(fooPage, hasSize(lessThan(10 + 1)));
    }

    @SuppressWarnings("unchecked")
    @Test
    public final void givenUsingTheCriteriaApi_whenRetrievingFirstPage_thenCorrect() {
        //4. Pagination With Hibernate Using the Criteria API
        final int pageSize = 10;

        final Criteria criteria = session.createCriteria(Foo.class);
        criteria.setFirstResult(0);
        criteria.setMaxResults(pageSize);
        final List<Foo> firstPage = criteria.list();

        assertThat(firstPage, hasSize(pageSize));
    }

    @SuppressWarnings("unchecked")
    @Test
    public final void givenUsingTheCriteriaApi_whenRetrievingPaginatedData_thenCorrect() {
        //برای بدست آوردن تعداد count ها میتوان از کد زیر هم استفاده که انعطاف پذیر هم میباشد
        final Criteria criteriaCount = session.createCriteria(Foo.class);
        criteriaCount.setProjection(Projections.rowCount());
        final Long count = (Long) criteriaCount.uniqueResult();

        int pageNumber = 1;
        final int pageSize = 10;
        final List<Foo> fooList = Lists.newArrayList();

        final Criteria criteria = session.createCriteria(Foo.class);
        int totalEntities = 0;
        while (totalEntities < count.intValue()) {
            criteria.setFirstResult((pageNumber - 1) * pageSize);
            criteria.setMaxResults(pageSize);
            fooList.addAll(criteria.list());
            totalEntities = fooList.size();
            pageNumber++;
        }
    }
    @Test
    public void givenEntitiesExist_whenRetrievingLastPage_thenCorrectSize() {
        //این یک مثال کامل از pagination است
        int pageSize = 10;
        String countQ = "Select count (f.id) from Foo f";
        Query countQuery = session.createQuery(countQ);
        Long countResults = (Long) countQuery.uniqueResult();
        int lastPageNumber = (int) (Math.ceil(countResults / pageSize));

        Query selectQuery = session.createQuery("From Foo");
        selectQuery.setFirstResult((lastPageNumber - 1) * pageSize);
        selectQuery.setMaxResults(pageSize);
        List<Foo> lastPage = selectQuery.list();

        assertThat(lastPage, hasSize(lessThan(pageSize + 1)));
    }

}
