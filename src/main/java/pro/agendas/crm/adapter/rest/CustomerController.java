package pro.agendas.crm.adapter.rest;

import pro.agendas.crm.application.CustomerUseCase;
import pro.agendas.crm.adapter.mapper.CustomerMapper;
import pro.agendas.crm.domain.model.Customer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<String> create(@RequestBody CustomerDTO dto) {
        Customer customer = mapper.toEntity(dto);
        useCase.createCustomer(customer);
        return ResponseEntity.ok("Customer created");
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerDTO> getById(@PathVariable String id) {
        return useCase.getCustomer(id)
                .map(mapper::toDTO)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
