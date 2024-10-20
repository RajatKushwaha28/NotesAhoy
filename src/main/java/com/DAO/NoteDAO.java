package com.DAO;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.entity.Note;
import com.entity.TrashNote;
import com.entity.User;
import com.helper.FactoryProvider;

public class NoteDAO {
	
	public List<Note> getAllNotes(String email)
	{
		Session sess = FactoryProvider.getSessionFactory().openSession();
		Transaction T = sess.beginTransaction();
		Criteria crit = sess.createCriteria(Note.class);
		
		UserDAO ud = new UserDAO();
		User u = ud.getUser(email);
		crit.add(Restrictions.eq("user", u));
		
		T.commit();
		List<Note> L = crit.list();
		
		return L;
		
	}
	
	public boolean saveNote(Note n, String email)
	{
		UserDAO ud = new UserDAO();
		User u = ud.getUser(email);
		n.setUser(u);
		List<Note> L = new ArrayList <Note>();
		L.add(n);
		u.setNotes(L);
		Session sess = FactoryProvider.getSessionFactory().openSession();
		Transaction T = sess.beginTransaction();
		Serializable i = sess.save(n);
		T.commit();
		if(i==null)
			return false;
		sess.close();
		return true;
	}
	public void deleteNote(int noteID)
	{
		Session sess = FactoryProvider.getSessionFactory().openSession();
		Transaction T = sess.beginTransaction();
		Note note = (Note)sess.get(Note.class, noteID);
		TrashNote tn =  new TrashNote(note);
		sess.save(tn);
		sess.delete(note);
		T.commit();
		sess.close();
	}
	
	public void updateNote(String title, String content, int ID, String eveDate, String time)
	{
		Session sess = FactoryProvider.getSessionFactory().openSession();
		Transaction T = sess.beginTransaction();
		
		Note note = (Note) sess.get(Note.class, ID);
		
		note.setTitle(title);
		note.setContent(content);
		note.setAddDate(new Date());
		note.setEventDate(eveDate);
		note.setTime(time);
		T.commit();
		sess.close();
	}
	
	public static int incrID()
	{
		int i = 101;
		Session sess = FactoryProvider.getSessionFactory().openSession();
		Query Q = sess.createQuery("SELECT n FROM Note n WHERE n.ID = (SELECT MAX(ID) FROM Note)");
		List <Note> L = Q.list();
		if(L.isEmpty())
			return i;
		else
		{
			Note n = L.get(0);
			i=n.getID();
			i++;
			return i;
		}
	}
	
	public List<Note> getNoteDates(String email)
	{
		UserDAO ud = new UserDAO();
		User u = ud.getUser(email);
		Session sess = FactoryProvider.getSessionFactory().openSession();
		Criteria crit = sess.createCriteria(Note.class);
		crit.add(Restrictions.ge("eventDate",new Date()));
		crit.add(Restrictions.eq("user", u));
		crit.addOrder(Order.asc("eventDate"));
		List<Note> eventDates = crit.list();
		return eventDates;

	}
	
	public Note getNote(int noteID)
	{
		Session sess = FactoryProvider.getSessionFactory().openSession();
		Transaction T =  sess.beginTransaction();
		Note n = sess.get(Note.class, noteID);
		T.commit();
		sess.close();
		return n;
	}
	
	public List<Note> getPublishable(String email)
	{
		Session sess = FactoryProvider.getSessionFactory().openSession();
		Transaction T = sess.beginTransaction();
		UserDAO ud = new UserDAO();
		User u = ud.getUser(email);
		Query Q = sess.createQuery("SELECT n FROM Note n WHERE n.ID NOT IN (SELECT s.ID FROM SharedNote s) and n.user = :u");
		Q.setParameter("u", u);
		List<Note> N = Q.list();
		return N;
	}
}
