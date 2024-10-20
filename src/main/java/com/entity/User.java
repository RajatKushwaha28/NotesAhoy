package com.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.DAO.AdminDAO;


@Entity
public class User {
	@Id
	String email;
	String fname;
	String lname;
	String password;
	@OneToMany
	List<Note> notes;
	@ManyToOne
	Admin admin;
	@OneToMany
	List<TrashNote> trash;
	@OneToMany
	List<SharedNote> shared;

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public List<Note> getNotes() {
		return notes;
	}
	public void setNotes(List<Note> notes) {
		this.notes = notes;
	}
	
	public User(String email, String fname, String lname, String password) {
		super();
		this.email = email;
		this.fname = fname;
		this.lname = lname;
		this.password = password;
		this.admin = AdminDAO.getAdmin();
	}
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "User [email=" + email + ", fname=" + fname + ", lname=" + lname + ", password=" + password + "]";
	}
	public Admin getAdmin() {
		return admin;
	}
	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	public List<TrashNote> getTrash() {
		return trash;
	}
	public void setTrash(List<TrashNote> trash) {
		this.trash = trash;
	}
	public List<SharedNote> getShared() {
		return shared;
	}
	public void setShared(List<SharedNote> shared) {
		this.shared = shared;
	}
	
	

}
