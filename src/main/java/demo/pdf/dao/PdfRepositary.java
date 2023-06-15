package demo.pdf.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import demo.pdf.model.PdfGenerator;

@Repository
public interface PdfRepositary extends JpaRepository<PdfGenerator, Integer> {

}
