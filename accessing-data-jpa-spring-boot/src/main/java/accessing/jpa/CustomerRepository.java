package accessing.jpa;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CustomerRepository extends CrudRepository<Customer,Long> {
    //این متد های data jpa است
    List<Customer> findByLastName(String lastName);
    Customer findById(long id);
}
