package demo.pdf.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import demo.pdf.dao.PdfRepositary;
import demo.pdf.export.PdfExport;
import demo.pdf.model.PdfGenerator;
import demo.pdf.service.PdfGeneratorService;

@RestController
@RequestMapping("/api")
public class PdfGeneratorController {
	
	@Autowired
	private PdfGeneratorService pdfGeneratorService;
	
	@RequestMapping(value="/welcome", method=RequestMethod.GET)
	public String list() {

		return "welcome";
	}
	
	@RequestMapping(value="/pdf", method=RequestMethod.GET)
     public String findAll(Model model) {
		List<PdfGenerator> pdf=pdfGeneratorService.findAll();
		model.addAttribute("pdfGenerator",pdf);
		return "pdfGeneratorList";
	}
	
	@GetMapping(value = "/exportpdf", produces = MediaType.APPLICATION_PDF_VALUE)
	
	public ResponseEntity<InputStreamResource> pdfReports(HttpServletResponse response) throws IOException {

		List<PdfGenerator> generate = pdfGeneratorService.findAll();

		ByteArrayInputStream bis = PdfExport.pdfReport(generate);

		HttpHeaders headers = new HttpHeaders();

		headers.add("Content-Disposition", "attachment;filename=pdfreport.pdf");

		return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF)
				.body(new InputStreamResource(bis));
	}
	
}
