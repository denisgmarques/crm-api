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

    public void validate() {
        if (name == null || name.isBlank())
            throw new IllegalArgumentException("Name is required");

        if (email == null || !email.contains("@"))
            throw new IllegalArgumentException("Invalid email");

        // Aqui você pode adicionar outras validações relevantes
    }

    public void updateEmail(String newEmail) {
        if (newEmail == null || !newEmail.contains("@"))
            throw new IllegalArgumentException("Invalid email");
        this.email = newEmail;
    }
}
