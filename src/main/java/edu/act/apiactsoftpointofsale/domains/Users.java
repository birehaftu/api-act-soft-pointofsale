package edu.act.apiactsoftpointofsale.domains;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Data
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @NotBlank(message = "Full Name is mandatory.")
    @Column(nullable = false)
    private String fullName;

    @NotBlank(message = "Role mandatory.")
    @Column(nullable = false)
    private String role;

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
