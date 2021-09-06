package edu.act.apiactsoftpointofsale.domains;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @NotBlank(message = "Full Name is mandatory.")
    @Column(nullable = false)
    private String FullName;

    @NotBlank(message = "Role mandatory.")
    @Column(nullable = false)
    private String Role;

    @NotBlank(message = "User name is mandatory.")
    @Column(nullable = false)
    private String userName;

    @NotBlank(message = "Email is mandatory.")
    @Column(nullable = false)
    private String email;

    @NotBlank(message = "password is mandatory.")
    @Column(nullable = false)
    private String password;

    @NotBlank(message = "phone is mandatory.")
    @Column(nullable = false)
    private String phone;

    @NotBlank(message = "status is mandatory.")
    @Column(nullable = false)
    private String status="InActive";
}
