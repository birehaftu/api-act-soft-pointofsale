package edu.act.apiactsoftpointofsale.domains;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long accountId;
    @Column(columnDefinition="serial")
    @Generated(GenerationTime.INSERT)
    private long accountNumber;
    @NotBlank(message = "AccountType mandatory.")
    @Column(nullable = false)
    private String accountType;

    @Column(nullable = false)
    private Double balance=0.0;

    @NotBlank(message = "Status is mandatory.")
    @Column(nullable = false)
    private String status;


    @ManyToOne(cascade = CascadeType.MERGE, optional = false)
    @JoinColumn(name = "customer_account_customer_id", nullable = false)
    private Customer customer;

    public Customer getCustomer_account() {
        return customer;
    }

    public void setCustomer_account(Customer customer) {
        this.customer = customer;
    }
}

