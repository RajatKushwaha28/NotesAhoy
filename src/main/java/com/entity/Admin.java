package com.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Admin {
	@Id
	String email;
	String password;
	@OneToMany
	List<User> users;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Admin(String email, String password, List<User> users) {
		super();
		this.email = email;
		this.users = users;
		this.password = password;
	}
	public Admin() {
		super();
		this.email="notesahoy2024@gmail.com";
		this.password="NotesAhoy";
	}
	@Override
	public String toString() {
		return "Admin [email=" + email + ", users=" + users + ", password=" + password + "]";
	}
	
}
