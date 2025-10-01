package pro.agendas.crm.application;

import pro.agendas.crm.domain.model.Customer;
import pro.agendas.crm.domain.repository.CustomerRepository;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class CustomerUseCase {

    private final CustomerRepository repository;

    public CustomerUseCase(CustomerRepository repository) {
        this.repository = repository;
    }

    public void createCustomer(Customer customer) {
        customer.validate();
        repository.save(customer);
    }

    public Optional<Customer> getCustomer(String id) {
        return repository.findById(id);
    }
}

