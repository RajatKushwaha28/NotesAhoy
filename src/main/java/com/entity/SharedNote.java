package com.entity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
public class SharedNote 
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
	@OneToOne
	Note note;
	
	public int getID() {
		return ID;
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
	public SharedNote() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public SharedNote(Note n)
	{
		this.ID = n.getID();
		this.Title = n.getTitle();
		this.Content = n.getContent();
		this.addDate = new Date();
		this.setEventDate(n.getEventDate());
		this.time = n.getTime();
		this.user = n.getUser();
	}

	public Note getNote() {
		return note;
	}

	public void setNote(Note note) {
		this.note = note;
	}

	@Override
	public String toString() {
		return "SharedNote [ID=" + ID + ", Title=" + Title + ", Content=" + Content + ", addDate=" + addDate
				+ ", eventDate=" + eventDate + ", time=" + time + ", user=" + user + ", note=" + note + "]";
	}
	
}
