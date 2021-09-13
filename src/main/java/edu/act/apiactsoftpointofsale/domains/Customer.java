package edu.act.apiactsoftpointofsale.domains;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Entity
@Data
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerId;

    @NotBlank(message = "Full Name is mandatory.")
    @Column(nullable = false)
    private String FullName;

    @NotBlank(message = "Date of Birth mandatory.")
    @Column(nullable = false)
    private Date DOB;

    @NotBlank(message = "phone is mandatory.")
    @Column(nullable = false)
    private String phone;

    @NotBlank(message = "Email is mandatory.")
    @Column(nullable = false)
    private String email;

    @NotBlank(message = "Merital Status is mandatory.")
    @Column(nullable = false)
    private String meritalStatus;

    @NotBlank(message = "Address is mandatory.")
    @Column(nullable = false)
    private String address;

   // @OneToMany(mappedBy="customer_account")
    //private Set<CustomerAccount> accounts;
}