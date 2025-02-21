package com.mphasis.eLearning.entity;
import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Instructor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int instructorId;
	
	private String instructorName;
	
	private String instructorContact;
	
	@OneToOne(cascade = CascadeType.ALL)
	private User userRef;
	
	public Instructor() {}

	public int getInstructorId() {
		return instructorId;
	}

	public void setInstructorId(int instructorId) {
		this.instructorId = instructorId;
	}

	public String getInstructorName() {
		return instructorName;
	}

	public void setInstructorName(String instructorName) {
		this.instructorName = instructorName;
	}

	public String getInstructorContact() {
		return instructorContact;
	}

	public void setInstructorContact(String instructorContact) {
		this.instructorContact = instructorContact;
	}

	public User getUserRef() {
		return userRef;
	}

	public void setUserRef(User userRef) {
		this.userRef = userRef;
	}

	@Override
	public String toString() {
		return "Instructor [instructorId=" + instructorId + ", instructorName=" + instructorName
				+ ", instructorContact=" + instructorContact + ", userRef=" + userRef + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(instructorContact, instructorId, instructorName, userRef);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Instructor other = (Instructor) obj;
		return Objects.equals(instructorContact, other.instructorContact) && instructorId == other.instructorId
				&& Objects.equals(instructorName, other.instructorName) && Objects.equals(userRef, other.userRef);
	};
	
	
	
	

}

