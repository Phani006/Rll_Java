package com.mphasis.eLearning.entity;
import java.util.Arrays;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
@Entity
public class Vedio {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int vedioId;
	
	private String vedioName;
	
	private String contentType;
	
	private String contentName;
	
	@Lob
	private byte[] vedioData;
	
	@JsonIgnore
	@ManyToOne(cascade = CascadeType.ALL)
	private Modules moduleRef;
	
	
	
	public byte[] getVedioData() {
		return vedioData;
	}



	public void setVedioData(byte[] vedioData) {
		this.vedioData = vedioData;
	}



	public Vedio() {}



	public int getVedioId() {
		return vedioId;
	}



	public void setVedioId(int vedioId) {
		this.vedioId = vedioId;
	}



	public String getVedioName() {
		return vedioName;
	}



	public void setVedioName(String vedioName) {
		this.vedioName = vedioName;
	}



	public String getContentType() {
		return contentType;
	}



	public void setContentType(String contentType) {
		this.contentType = contentType;
	}



	public String getContentName() {
		return contentName;
	}



	public void setContentName(String contentName) {
		this.contentName = contentName;
	}



//	public byte[] getVedioData() {
//		return vedioData;
//	}



//	public void setVedioData(byte[] vedioData) {
//		this.vedioData = vedioData;
//	}



	public Modules getModuleRef() {
		return moduleRef;
	}



	public void setModuleRef(Modules moduleRef) {
		this.moduleRef = moduleRef;
	}



	public Vedio(int vedioId, String vedioName, String contentType, String contentName,
			Modules moduleRef) {
		super();
		this.vedioId = vedioId;
		this.vedioName = vedioName;
		this.contentType = contentType;
		this.contentName = contentName;
		//this.vedioData = vedioData;
		this.moduleRef = moduleRef;
	}



	@Override
	public String toString() {
		return "Vedio [vedioId=" + vedioId + ", vedioName=" + vedioName + ", contentType=" + contentType
				+ ", contentName=" + contentName + ", vedioData=" + Arrays.toString(vedioData) + ", moduleRef="
				+ moduleRef + "]";
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(vedioData);
		result = prime * result + Objects.hash(contentName, contentType, moduleRef, vedioId, vedioName);
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vedio other = (Vedio) obj;
		return Objects.equals(contentName, other.contentName) && Objects.equals(contentType, other.contentType)
				&& Objects.equals(moduleRef, other.moduleRef) && Arrays.equals(vedioData, other.vedioData)
				&& vedioId == other.vedioId && Objects.equals(vedioName, other.vedioName);
	};
	
	
	

}
