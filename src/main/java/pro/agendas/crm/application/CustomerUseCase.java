package pro.agendas.crm.application;

import org.springframework.stereotype.Service;
import pro.agendas.crm.domain.model.Customer;
import pro.agendas.crm.domain.repository.CustomerRepository;

import java.util.Optional;
import java.util.UUID;

@Service
public class CustomerUseCase {

    private final CustomerRepository repository;

    public CustomerUseCase(CustomerRepository repository) {
        this.repository = repository;
    }

    public Customer createCustomer(Customer customer) {
        if (customer.getId() != null && !customer.getId().isBlank()) {
            repository.findById(customer.getId()).ifPresent(existingCustomer -> {
                throw new IllegalArgumentException("Customer with ID " + customer.getId() + " already exists.");
            });
        } else {
            customer.setId(UUID.randomUUID().toString());
        }
        return repository.save(customer);
    }

    public Optional<Customer> getCustomer(String id) {
        return repository.findById(id);
    }
}

