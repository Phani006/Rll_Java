package com.mphasis.eLearning.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Support {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int supportId;
	private  String supportName;
	private String supportType;
	private String Issue;
	private String status;
	@ManyToOne(cascade = CascadeType.MERGE)
	private User user;
	public int getSupportId() {
		return supportId;
	}
	public void setSupportId(int supportId) {
		this.supportId = supportId;
	}
	public String getSupportName() {
		return supportName;
	}
	public void setSupportName(String supportName) {
		this.supportName = supportName;
	}
	public String getSupportType() {
		return supportType;
	}
	public void setSupportType(String supportType) {
		this.supportType = supportType;
	}
	public String getIssue() {
		return Issue;
	}
	public void setIssue(String issue) {
		Issue = issue;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Support(int supportId, String supportName, String supportType, String issue, String status, User user) {
		super();
		this.supportId = supportId;
		this.supportName = supportName;
		this.supportType = supportType;
		Issue = issue;
		this.status = status;
		this.user = user;
	}
	public Support() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Support [supportId=" + supportId + ", supportName=" + supportName + ", supportType=" + supportType
				+ ", Issue=" + Issue + ", status=" + status + ", user=" + user + "]";
	}
	
	
	
	
}
