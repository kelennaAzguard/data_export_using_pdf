package pdf.export.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletResponse;
import pdf.export.model.Account;
import pdf.export.model.Transaction;
import pdf.export.model.User;
import pdf.export.service.BankingService;
import pdf.export.service.UserReportService;

@RestController
@RequestMapping("/api/banking")
public class BankingController {

	@Autowired
	private UserReportService userReportService;

	@Autowired
	private BankingService bankingService;

	@PostMapping("/user")
	public User createUser(@RequestBody User user) {
		return bankingService.saveUser(user);
	}

	@GetMapping("/users")
	public List<User> getAllUsers() {
		return bankingService.getAllUsers();
	}

	@PostMapping("/account")
	public Account createAccount(@RequestBody Account account) {
		return bankingService.saveAccount(account);
	}

	@PostMapping("/transaction")
	public Transaction createTransaction(@RequestBody Transaction transaction) {
		return bankingService.saveTransaction(transaction);
	}

	@GetMapping("/pdf/{transcationId}")
	public void exportToPdf(HttpServletResponse response , @PathVariable("transcationId") Long transcationId) throws IOException {
		this.userReportService.exportToPdf(response,transcationId);
	}
	
	@GetMapping("/excel/{transcationId}")
	public void exportToExcel(HttpServletResponse response , @PathVariable("transcationId") Long transcationId) throws IOException {
		this.userReportService.exportToExcel(response,transcationId);
	}

}