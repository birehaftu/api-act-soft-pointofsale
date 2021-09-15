package edu.act.apiactsoftpointofsale.domains;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.time.LocalDateTime;

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
    private LocalDateTime dateofTransaction;

    @NotBlank(message = "status mandatory.")
    @Column(nullable = false)
    private String status;

    @NotBlank(message = "goodName mandatory.")
    @Column(nullable = false)
    private String goodName;


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
    private Users transaction_user;

    public Users getUser_Transaction() {
        return transaction_user;
    }

    public void setUser_Transaction(Users user_transaction) {
        this.transaction_user = user_transaction;
    }
}
