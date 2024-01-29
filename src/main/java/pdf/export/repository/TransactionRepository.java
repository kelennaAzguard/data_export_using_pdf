package pdf.export.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pdf.export.model.Transaction;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    // Additional custom queries can be added if needed
}