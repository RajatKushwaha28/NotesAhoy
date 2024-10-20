package com.entity;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.DAO.NoteDAO;

@Entity
public class Note 
{
	@Id
	private int ID;
	private String Title;
	@Column(length = 5000)
	private String Content;
	@Temporal(TemporalType.DATE)
	private Date addDate;
	@Temporal(TemporalType.DATE)
	private Date eventDate;
	private String time;
	@ManyToOne
	User user;
	
	public int getID() {
		return ID;
	}
	public void setID() {
		ID = NoteDAO.incrID();
	}
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	public String getContent() {
		return Content;
	}
	public void setContent(String content) {
		Content = content;
	}
	public Date getAddDate() {
		return addDate;
	}
	public void setAddDate(Date addDate) {
		this.addDate = addDate;
	}
	
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}	
	
	public String getEventDate() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		return dateFormat.format(eventDate);
	}
	public void setEventDate(String eventDate) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		try {
			this.eventDate = dateFormat.parse(eventDate);
		} catch (ParseException e) {
			
			e.printStackTrace();
		}
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	
	
	public Note(int iD, String title, String content, Date addDate, User user) {
		super();
		ID = iD;
		Title = title;
		Content = content;
		this.addDate = addDate;
		this.user = user;
	}
	public Note() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Note [ID=" + ID + ", Title=" + Title + ", Content=" + Content + ", addDate=" + addDate + "]";
	}
	
	public Note(TrashNote n)
	{
		this.ID = NoteDAO.incrID();
		this.Title = n.getTitle();
		this.Content = n.getContent();
		this.addDate = n.getAddDate();
		this.setEventDate(n.getEventDate());
		this.time = n.getTime();
		this.user = n.getUser();
	}
	
}
