package demo.pdf.export;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.List;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import demo.pdf.model.PdfGenerator;

public class PdfExport {

	public static ByteArrayInputStream pdfReport(List<PdfGenerator> pdfGenerator) {

		Document document = new Document();
		ByteArrayOutputStream out = new ByteArrayOutputStream();

		try {

			PdfPTable table = new PdfPTable(5);
			table.setWidthPercentage(80);
			table.setWidths(new int[] { 6, 6, 6, 6, 6 });

			Font headFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD);

			PdfPCell horcell;

			horcell = new PdfPCell(new Phrase("Firstname", headFont));
			horcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(horcell);

			horcell = new PdfPCell(new Phrase("Lastname", headFont));
			horcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(horcell);

			horcell = new PdfPCell(new Phrase("Gender", headFont));
			horcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(horcell);

			horcell = new PdfPCell(new Phrase("Email", headFont));
			horcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(horcell);

			horcell = new PdfPCell(new Phrase("Designation", headFont));
			horcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(horcell);

			for (PdfGenerator pdfGenerator1 : pdfGenerator) {

				PdfPCell cell;

				cell = new PdfPCell(new Phrase(pdfGenerator1.getFirstname()));
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);

				cell = new PdfPCell(new Phrase(pdfGenerator1.getLastname()));
				cell.setPaddingLeft(5);
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);

				cell = new PdfPCell(new Phrase(pdfGenerator1.getGender()));
				cell.setPaddingLeft(5);
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);

				cell = new PdfPCell(new Phrase(String.valueOf(pdfGenerator1.getEmail())));
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				cell.setPaddingRight(5);
				table.addCell(cell);

				cell = new PdfPCell(new Phrase(String.valueOf(pdfGenerator1.getDesignation())));
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				cell.setPaddingRight(5);
				table.addCell(cell);
			}

			PdfWriter.getInstance(document, out);
			document.open();
			document.add(table);

			document.close();

		} catch (DocumentException ex) {

		}

		return new ByteArrayInputStream(out.toByteArray());
	}

}
