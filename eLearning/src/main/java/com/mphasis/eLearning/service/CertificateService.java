package com.mphasis.eLearning.service;

import java.io.ByteArrayOutputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.mphasis.eLearning.repository.CertificateRepository;

@Service
public class CertificateService implements ICertificateService{
	
	@Autowired
	CertificateRepository certificateRepository;

	

	@Override
	public byte[] generateCertificate(String userName, String courseName) {
		 ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
	        Document document = new Document();
	        
	        try {
	            PdfWriter writer = PdfWriter.getInstance(document, outputStream);
	            document.open();
	            
	            // Set a custom font (using the default font if necessary)
	            Font titleFont = new Font(Font.FontFamily.HELVETICA, 24, Font.BOLD);
	            Font subtitleFont = new Font(Font.FontFamily.HELVETICA, 18);
	            Font textFont = new Font(Font.FontFamily.HELVETICA, 16);
	            
	            // Title of the certificate
	            document.add(new Paragraph("Certificate of Completion", titleFont));
	           

	            // Subtitle and name
	            document.add(new Paragraph("This is to certify that", subtitleFont));
	            document.add(Chunk.NEWLINE);
	            document.add(new Paragraph(userName, new Font(Font.FontFamily.HELVETICA, 20, Font.BOLD)));
	            document.add(Chunk.NEWLINE);

	            // Course Name
	            document.add(new Paragraph("has successfully completed the course:", textFont));
	            document.add(Chunk.NEWLINE);
	            document.add(new Paragraph(courseName, new Font(Font.FontFamily.HELVETICA, 18, Font.BOLD)));
	            document.add(Chunk.NEWLINE);

	            // Date
	            document.add(new Paragraph("Date: " + java.time.LocalDate.now().toString(), textFont));

	            document.close();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return outputStream.toByteArray();
	    }

 
}

