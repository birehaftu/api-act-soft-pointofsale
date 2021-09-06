package edu.act.apiactsoftpointofsale.domains;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.awt.geom.Arc2D;
import java.util.Date;

@Entity
@Data
public class CardTransaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long transactionId;

    @NotBlank(message = "Amount is mandatory.")
    @Column(nullable = false)
    private Double Amount;

    @NotBlank(message = "Date of Transaction is mandatory.")
    @Column(nullable = false)
    private  Date dateofTransaction;

    @NotBlank(message = "status mandatory.")
    @Column(nullable = false)
    private String status;


    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "customer_transaction_card_id", nullable = false)
    private CustomerCard transaction_card;

    public CustomerCard getCard_Transaction() {
        return transaction_card;
    }

    public void setCard_Transaction(CustomerCard transaction_card) {
        this.transaction_card = transaction_card;
    }
    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "user_transaction_user_id", nullable = false)
    private User user_transaction;

    public User getUser_Transaction() {
        return user_transaction;
    }

    public void setUser_Transaction(User user_transaction) {
        this.user_transaction = user_transaction;
    }
}
