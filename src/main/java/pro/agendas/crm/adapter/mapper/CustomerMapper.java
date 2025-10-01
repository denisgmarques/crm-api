package pro.agendas.crm.adapter.mapper;

import pro.agendas.crm.adapter.rest.CustomerDTO;
import pro.agendas.crm.domain.model.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);

    Customer toEntity(CustomerDTO dto);
    CustomerDTO toDTO(Customer customer);
}

