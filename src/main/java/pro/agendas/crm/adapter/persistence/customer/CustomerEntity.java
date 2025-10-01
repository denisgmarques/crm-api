package pro.agendas.crm.adapter.persistence.customer;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "CLIENTE")
@Data
public class CustomerEntity {

    @Id
    private String id;
    private String name;
    private String email;

    private String phone;
    private String mobile;

    private String taxId;
    private String companyRegistrationNumber;

    private String street;
    private String number;
    private String complement;
    private String city;
    private String state;
    private String postalCode;

    private String channel;
}
