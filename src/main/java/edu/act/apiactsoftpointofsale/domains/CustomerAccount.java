package edu.act.apiactsoftpointofsale.domains;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@SequenceGenerator(name="accountnumberseq", initialValue=1000000000, allocationSize=10)
public class CustomerAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long accountId;

    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="accountnumberseq")
    @NotBlank(message = "AccountNumber is mandatory.")
    @Column(nullable = false)
    private String accountNumber;
    @NotBlank(message = "AccountType mandatory.")
    @Column(nullable = false)
    private String accountType;

    @NotBlank(message = "Balanace is mandatory.")
    @Column(nullable = false)
    private Double balance=0.0;

    @NotBlank(message = "Status is mandatory.")
    @Column(nullable = false)
    private String status;


    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "customer_account_customer_id", nullable = false)
    private Customer customer;

    public Customer getCustomer_account() {
        return customer;
    }

    public void setCustomer_account(Customer customer) {
        this.customer = customer;
    }
}

