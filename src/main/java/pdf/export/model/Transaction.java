package pdf.export.model;

import java.math.BigDecimal;

import java.time.LocalDateTime;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false,exclude ="account")
@Entity
@Table(name="transcation")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long transactionId;

    private String description;
    private String transactionType;
    private LocalDateTime timestamp;
    private BigDecimal amount;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;
}