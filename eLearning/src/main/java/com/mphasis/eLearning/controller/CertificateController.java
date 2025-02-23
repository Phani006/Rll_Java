package com.mphasis.eLearning.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mphasis.eLearning.service.ICertificateService;

@RestController
@RequestMapping("certificate")
@CrossOrigin("*")
public class CertificateController {
	
	@Autowired
	private  ICertificateService certificateService;
	 
  
    @GetMapping("generate")
    public ResponseEntity<byte[]> generateCertificate(@RequestParam String userName, 
                                                      @RequestParam String courseName) {
        byte[] pdfBytes = certificateService.generateCertificate(userName, courseName);
 
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "attachment; filename=certificate.pdf");
        return new ResponseEntity<>(pdfBytes, headers, HttpStatus.OK);
    }

}
