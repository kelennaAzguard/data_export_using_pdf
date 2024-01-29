package pdf.export.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pdf.export.model.Account;
import pdf.export.model.Transaction;
import pdf.export.model.User;
import pdf.export.repository.AccountRepository;
import pdf.export.repository.TransactionRepository;
import pdf.export.repository.UserRepository;

@Service
public class BankingService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private TransactionRepository transactionRepository;

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Account saveAccount(Account account) {
        return accountRepository.save(account);
    }

    public Transaction saveTransaction(Transaction transaction) {
        return transactionRepository.save(transaction);
    }
}
