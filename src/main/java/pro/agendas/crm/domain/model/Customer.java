package pro.agendas.crm.domain.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Customer {

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

    public void updateEmail(String newEmail) {
        this.email = newEmail;
    }
}
