package com.DAO;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.entity.Note;
import com.entity.TrashNote;
import com.entity.User;
import com.helper.FactoryProvider;

public class TrashNoteDAO 
{
	public List<TrashNote> getAllTrashNotes(String email)
	{
		Session sess = FactoryProvider.getSessionFactory().openSession();
		Transaction T = sess.beginTransaction();
		Criteria crit = sess.createCriteria(TrashNote.class);
		
		UserDAO ud = new UserDAO();
		User u = ud.getUser(email);
		crit.add(Restrictions.eq("user", u));
		
		T.commit();
		List<TrashNote> L = crit.list();
		
		return L;
	}
	public static int incrID()
	{
		int i = 101;
		Session sess = FactoryProvider.getSessionFactory().openSession();
		Query Q = sess.createQuery("SELECT n FROM TrashNote n WHERE n.ID = (SELECT MAX(ID) FROM TrashNote)");
		List <TrashNote> L = Q.list();
		if(L.isEmpty())
			return i;
		else
		{
			TrashNote n = L.get(0);
			i=n.getID();
			i++;
			return i;
		}
	}
	
	public void deleteNote(int noteID)
	{
		Session sess = FactoryProvider.getSessionFactory().openSession();
		Transaction T = sess.beginTransaction();
		TrashNote note = (TrashNote)sess.get(TrashNote.class, noteID);
		sess.delete(note);
		T.commit();
		sess.close();
	}
	
	public void restoreNote(int noteID)
	{
		Session sess = FactoryProvider.getSessionFactory().openSession();
		Transaction T = sess.beginTransaction();
		TrashNote tn = sess.get(TrashNote.class, noteID);
		Note n = new Note(tn);
		sess.save(n);
		sess.delete(tn);
		T.commit();
	}

}
