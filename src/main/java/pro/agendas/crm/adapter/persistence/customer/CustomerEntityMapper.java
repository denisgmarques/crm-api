package pro.agendas.crm.adapter.persistence.customer;

import pro.agendas.crm.domain.model.Customer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerEntityMapper {
    CustomerEntity toEntity(Customer customer);
    Customer toDomain(CustomerEntity entity);
}

