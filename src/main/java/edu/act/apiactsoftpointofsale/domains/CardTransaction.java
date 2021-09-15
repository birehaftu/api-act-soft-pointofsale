package edu.act.apiactsoftpointofsale.domains;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CardTransaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long transactionId;

    @Column(nullable = false)
    private Double amount;

    @Column(nullable = false)
    private  LocalDate dateofTransaction;

    @NotBlank(message = "status mandatory.")
    @Column(nullable = false)
    private String status;


    @ManyToOne(cascade = CascadeType.MERGE, optional = false)
    @JoinColumn(name = "customer_transaction_card_id", nullable = false)
    private CustomerCard transaction_card;

    public CustomerCard getCard_Transaction() {
        return transaction_card;
    }

    public void setCard_Transaction(CustomerCard transaction_card) {
        this.transaction_card = transaction_card;
    }
    @ManyToOne(cascade = CascadeType.MERGE, optional = false)
    @JoinColumn(name = "user_transaction_user_id", nullable = false)
    private Users user_transaction;

    public Users getUser_Transaction() {
        return user_transaction;
    }

    public void setUser_Transaction(Users user_transaction) {
        this.user_transaction = user_transaction;
    }
}
