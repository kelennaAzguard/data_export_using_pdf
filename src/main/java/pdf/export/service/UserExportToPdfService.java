package pdf.export.service;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.lowagie.text.Document;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import jakarta.servlet.http.HttpServletResponse;
import pdf.export.model.Transaction;
import report.ReportAbstract;

@Service
public class UserExportToPdfService extends ReportAbstract {

	public PdfPCell writeTableData(PdfPTable table, Object data) {
		List<Transaction> transcations = (List<Transaction>) data;

		// for auto wide by paper size
		table.setWidthPercentage(100);
		PdfPCell cell = new PdfPCell();
		// cell
		transcations.stream().forEach(transcation->{
	
		int number = 0;
		number += 1;
		cell.setPhrase(new Phrase(String.valueOf(number), getFontContent()));
		table.addCell(cell);

		cell.setPhrase(new Phrase(transcation.getDescription(), getFontContent()));
		table.addCell(cell);

		cell.setPhrase(new Phrase(transcation.getTransactionType(), getFontContent()));
		table.addCell(cell);

		cell.setPhrase(new Phrase(transcation.getAccount().getAccountNumber(), getFontContent()));
		table.addCell(cell);

		cell.setPhrase(new Phrase(transcation.getTimestamp().toString(), getFontContent()));
		table.addCell(cell);

		cell.setPhrase(new Phrase(transcation.getAmount().toString(), getFontContent()));
		table.addCell(cell);
		});
		return cell;

	}

	public void exportToPDF(HttpServletResponse response, Object data) throws IOException {

		// init respose
		response = initResponseForExportPdf(response, "Transaction");

		// define paper size
		Document document = new Document(PageSize.A4);
		PdfWriter.getInstance(document, response.getOutputStream());

		// start document
		document.open();

		// title
		Paragraph title = new Paragraph("Transcation Report", getFontTitle());
		title.setAlignment(Paragraph.ALIGN_CENTER);
		document.add(title);

		// subtitel
		Paragraph subtitel = new Paragraph("Report Date : " + LocalDate.now(), getFontSubtitle());
		subtitel.setAlignment(Paragraph.ALIGN_LEFT);
		document.add(subtitel);

		enterSpace(document);

		// table header
		String[] headers = new String[] { "No", "Description", "TransactionType", "AccountNumber", "getTimestamp",
				"Amount" };
		PdfPTable tableHeader = new PdfPTable(6);
		writeTableHeaderPdf(tableHeader, headers);
		document.add(tableHeader);

		// table content
		PdfPTable tableData = new PdfPTable(5);
//		writeTableData(tableData, data);
		tableData.addCell(writeTableData(tableData, data));
		document.add(tableData);

		document.close();
	}

}
