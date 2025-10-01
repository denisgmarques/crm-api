package pro.agendas.crm.domain.repository;

import pro.agendas.crm.domain.model.Customer;
import java.util.Optional;

public interface CustomerRepository {
    Customer save(Customer customer);
    Optional<Customer> findById(String id);
}

