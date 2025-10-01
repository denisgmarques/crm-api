package pro.agendas.crm.adapter.rest;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pro.agendas.crm.adapter.mapper.CustomerMapper;
import pro.agendas.crm.application.CustomerUseCase;
import pro.agendas.crm.domain.model.Customer;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerUseCase useCase;
    private final CustomerMapper mapper;

    public CustomerController(CustomerUseCase useCase, CustomerMapper mapper) {
        this.useCase = useCase;
        this.mapper = mapper;
    }

    @PostMapping
    public ResponseEntity<CustomerDTO> create(@Valid @RequestBody CustomerDTO dto) {
        Customer customer = mapper.toEntity(dto);
        Customer createdCustomer = useCase.createCustomer(customer);
        CustomerDTO createdDto = mapper.toDTO(createdCustomer);

        return ResponseEntity.status(HttpStatus.CREATED).body(createdDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerDTO> getById(@PathVariable String id) {
        return useCase.getCustomer(id)
                .map(mapper::toDTO)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
