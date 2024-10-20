package com.DAO;

import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.entity.Admin;
import com.entity.Note;
import com.entity.User;
import com.helper.FactoryProvider;

public class AdminDAO {

	public static Admin getAdmin() {
		Admin A = new Admin();
		return A;
	}
	
	public boolean checkAdmin()
	{
		Session sess = FactoryProvider.getSessionFactory().openSession();
		Transaction T = sess.beginTransaction();
		Query Q = sess.createQuery("from Admin");
		T.commit();
		List<Admin> L = Q.list();
		sess.close();
		if(L.isEmpty())
			return true;
		return false;
		
	}
	
	public void saveAdmin()
	{
		Admin a = getAdmin();
		Session sess = FactoryProvider.getSessionFactory().openSession();
		Transaction T = sess.beginTransaction();
		sess.save(a);
		T.commit();
		sess.close();
	}
	
	public void sendMail()
	{
		Admin a = getAdmin();
        // Sender's email ID needs to be mentioned
        String from = a.getEmail();
        String pass = "cwfs hapw sake texz";
        // Assuming you are sending email from through gmails smtp
        String host = "smtp.gmail.com";

        List<Note> N = getUserEmails();
        if(N.isEmpty())
        	return;
        
        // Get system properties
        Properties properties = System.getProperties();

        // Setup mail server
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");

        // Get the Session object.// and pass username and password
        javax.mail.Session session = javax.mail.Session.getInstance(properties, new javax.mail.Authenticator() {

            protected PasswordAuthentication getPasswordAuthentication() {

                return new PasswordAuthentication(from, pass);

            }

        });

        // Used to debug SMTP issues
        session.setDebug(true);

        try {
            for(Note note:N)
            {
            	String to = note.getUser().getEmail();
            	MimeMessage message = new MimeMessage(session);

            	// Set From: header field of the header.
            	message.setFrom(new InternetAddress(from));

            	// Set To: header field of the header.
            	message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

            	// Set Subject: header field
            	message.setSubject("Event Reminder : "+note.getTitle());

            	// Now set the actual message
            	message.setText("Event at : "+note.getTime()+"\n"+note.getContent());

            	System.out.println("sending...");
            	// Send message
            	Transport.send(message);
            	System.out.println("Sent message successfully....");
            }
        } 
        catch (MessagingException mex) {
            mex.printStackTrace();
        }

	}
	
	public List<Note> getUserEmails()
	{
		String query = "SELECT n FROM Note n WHERE n.eventDate = CURRENT_DATE";
		Session sess = FactoryProvider.getSessionFactory().openSession();
		Query Q = sess.createQuery(query);
		List <Note> L = Q.list();
		sess.close();
		return L;
	}
	
	
	
}
