package pro.agendas.crm.application;

import pro.agendas.crm.domain.model.Customer;
import pro.agendas.crm.domain.repository.CustomerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class CustomerUseCaseTest {

    private CustomerRepository repository;
    private CustomerUseCase useCase;

    @BeforeEach
    public void setUp() {
        repository = mock(CustomerRepository.class);
        useCase = new CustomerUseCase(repository);
    }

    @Test
    public void testCreateCustomer_success() {
        Customer customer = new Customer("1", "John Doe", "john@example.com",
                "123456", "987654", "123456789", "987654321",
                "Main St", "100", "Apt 1", "NY", "NY", "12345", "Online");

        useCase.createCustomer(customer);
        verify(repository, times(1)).save(customer);
    }

    @Test
    public void testGetCustomer_found() {
        Customer customer = new Customer("1", "John Doe", "john@example.com",
                "123456", "987654", "123456789", "987654321",
                "Main St", "100", "Apt 1", "NY", "NY", "12345", "Online");

        when(repository.findById("1")).thenReturn(Optional.of(customer));

        Optional<Customer> result = useCase.getCustomer("1");

        assertTrue(result.isPresent());
        assertEquals("John Doe", result.get().getName());
    }
}

