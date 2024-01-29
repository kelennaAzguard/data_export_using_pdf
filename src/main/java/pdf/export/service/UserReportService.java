package pdf.export.service;

import java.io.IOException;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.servlet.http.HttpServletResponse;
import pdf.export.model.Transaction;
import pdf.export.repository.TransactionRepository;

@Service
public class UserReportService {

	@Autowired
	private TransactionRepository transactionRepository;

	@Autowired
	private UserExportToPdfService userExportToPdfService;

	public void exportToPdf(HttpServletResponse response, Long transcationId) throws IOException {
		// get all user
		Transaction data = transactionRepository.findById(transcationId).orElse(null);

		// export to pdf
		userExportToPdfService.exportToPDF(response, Arrays.asList(data));
	}

}
