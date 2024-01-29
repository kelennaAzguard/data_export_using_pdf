package pdf.export.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pdf.export.model.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
    // Additional custom queries can be added if needed
}