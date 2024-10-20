package com.DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.entity.Note;
import com.entity.SharedNote;
import com.helper.FactoryProvider;

public class SharedNotesDAO 
{
	public List<SharedNote> getAllSharedNotes()
	{
		Session sess = FactoryProvider.getSessionFactory().openSession();
		Transaction T = sess.beginTransaction();
		Query Q = sess.createQuery("from SharedNote");
		List<SharedNote> L = Q.list();
		T.commit();
		sess.close();
		return L;
	}
	public void shareNote(int noteID)
	{
		Session sess = FactoryProvider.getSessionFactory().openSession();
		Transaction T = sess.beginTransaction();
		NoteDAO nd = new NoteDAO();
		Note n = nd.getNote(noteID);
		SharedNote sn = new SharedNote(n);
		sess.save(sn);
		T.commit();
		sess.close();
	}
}
