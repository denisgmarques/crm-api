package pro.agendas.crm.adapter.persistence.customer;

import pro.agendas.crm.domain.model.Customer;
import pro.agendas.crm.domain.repository.CustomerRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public class CustomerRepositoryImpl implements CustomerRepository {

    private final CustomerJpaRepository jpaRepository;
    private final CustomerEntityMapper mapper;

    public CustomerRepositoryImpl(CustomerJpaRepository jpaRepository, CustomerEntityMapper mapper) {
        this.jpaRepository = jpaRepository;
        this.mapper = mapper;
    }

    @Override
    public void save(Customer customer) {
        jpaRepository.save(mapper.toEntity(customer));
    }

    @Override
    public Optional<Customer> findById(String id) {
        return jpaRepository.findById(id).map(mapper::toDomain);
    }
}
