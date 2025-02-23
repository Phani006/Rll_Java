package com.mphasis.eLearning.entity;

import java.time.LocalDate;
import java.util.Arrays;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
 
@Entity
@Table(name = "certificates")
public class Certificates {
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
 
    private String userName;
    private String courseName;
    private LocalDate issueDate;
    private String fileName; // Certificate file name
 
    @Lob
    private byte[] pdfData; // Store certificate as binary data
 
    public Certificates() {
        this.issueDate = LocalDate.now(); // Automatically set issue date
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public LocalDate getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(LocalDate issueDate) {
		this.issueDate = issueDate;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public byte[] getPdfData() {
		return pdfData;
	}

	public void setPdfData(byte[] pdfData) {
		this.pdfData = pdfData;
	}

	public Certificates(Long id, String userName, String courseName, LocalDate issueDate, String fileName,
			byte[] pdfData) {
		super();
		this.id = id;
		this.userName = userName;
		this.courseName = courseName;
		this.issueDate = issueDate;
		this.fileName = fileName;
		this.pdfData = pdfData;
	}

	@Override
	public String toString() {
		return "Certificates [id=" + id + ", userName=" + userName + ", courseName=" + courseName + ", issueDate="
				+ issueDate + ", fileName=" + fileName + ", pdfData=" + Arrays.toString(pdfData) + "]";
	}
}
