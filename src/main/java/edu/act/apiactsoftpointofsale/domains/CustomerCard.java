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
public class CustomerCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long cardId;

    @NotBlank(message = "pin mandatory.")
    @Column(nullable = false)
    private String pin;

    @NotBlank(message = "cardCode is mandatory.")
    @Column(nullable = false)
    private String cardCode;

    @NotBlank(message = "status is mandatory.")
    @Column(nullable = false)
    private String status;


    @ManyToOne(cascade = CascadeType.MERGE, optional = false)
    @JoinColumn(name = "customer_card_account_id", nullable = false)
    private CustomerAccount customer_account;

    public CustomerAccount getCustomer_card() {
        return customer_account;
    }

    public void setCustomer_card(CustomerAccount customer_account) {
        this.customer_account = customer_account;
    }
}
