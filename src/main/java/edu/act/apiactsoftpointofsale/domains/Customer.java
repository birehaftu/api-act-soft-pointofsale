package edu.act.apiactsoftpointofsale.domains;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerId;

    @NotBlank(message = "Full Name is mandatory.")
    @Column(nullable = false)
    private String fullName;

    @NotBlank(message = "Date of Birth mandatory.")
    @Column(nullable = false)
    private LocalDate dob;

    @NotBlank(message = "phone is mandatory.")
    @Column(nullable = false)
    private String phone;

    @NotBlank(message = "Email is mandatory.")
    @Column(nullable = false)
    private String email;

    @NotBlank(message = "Merital Status is mandatory.")
    @Column(nullable = false)
    private String maritalStatus;

    @NotBlank(message = "Address is mandatory.")
    @Column(nullable = false)
    private String address;

}