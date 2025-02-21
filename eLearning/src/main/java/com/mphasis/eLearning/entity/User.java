package com.mphasis.eLearning.entity;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;
private String password;
private String email;
private String role;
public int getUserId() {
	return userId;
}
public void setUserId(int userId) {
	this.userId = userId;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getRole() {
	return role;
}
public void setRole(String role) {
	this.role = role;
}
@Override
public int hashCode() {
	return Objects.hash(email, password, role, userId);
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	User other = (User) obj;
	return Objects.equals(email, other.email) && Objects.equals(password, other.password)
			&& Objects.equals(role, other.role) && userId == other.userId;
}
@Override
public String toString() {
	return "User [userId=" + userId + ", password=" + password + ", email=" + email + ", role=" + role + "]";
}
public User() {
	super();
	// TODO Auto-generated constructor stub
}
public User(int userId, String password, String email, String role) {
	super();
	this.userId = userId;
	this.password = password;
	this.email = email;
	this.role = role;
}



}
