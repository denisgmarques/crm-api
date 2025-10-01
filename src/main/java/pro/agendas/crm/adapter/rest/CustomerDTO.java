package pro.agendas.crm.adapter.rest;

import lombok.Data;

@Data
public class CustomerDTO {
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
