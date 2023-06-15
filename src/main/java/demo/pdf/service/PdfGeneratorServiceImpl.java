package demo.pdf.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import demo.pdf.dao.PdfRepositary;
import demo.pdf.model.PdfGenerator;

@Service
public class PdfGeneratorServiceImpl implements PdfGeneratorService {
	
	@Autowired
	private PdfRepositary pdfRepositary;

	@Override
	public List<PdfGenerator> findAll() {
		return pdfRepositary.findAll();
	}

}
