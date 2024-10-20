package com.entity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.DAO.NoteDAO;
import com.DAO.TrashNoteDAO;

@Entity
public class TrashNote {
	@Id
	private int ID;
	private String title;
	@Column(length = 5000)
	private String Content;
	@Temporal(TemporalType.DATE)
	private Date addDate;
	@Temporal(TemporalType.DATE)
	private Date eventDate;
	@Temporal(TemporalType.DATE)
	private Date delDate;
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
		return title;
	}
	public void setTitle(String title) {
		title = title;
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
	public String getDelDate() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		return dateFormat.format(delDate);
	}
	public void setDelDate(String delDate) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		try {
			this.delDate = dateFormat.parse(delDate);
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
	
	public TrashNote(Note n)
	{
		this.ID = TrashNoteDAO.incrID();
		this.title = n.getTitle();
		this.Content = n.getContent();
		this.addDate = n.getAddDate();
		this.setEventDate(n.getEventDate());
		this.time = n.getTime();
		this.user = n.getUser();
		this.delDate = new Date();
	}
	public  TrashNote()
	{}
}
