package org.deveshgupta.orm;

import java.util.Calendar;
import java.util.Date;

import org.deveshgupta.orm.model.Message;
import org.deveshgupta.orm.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		User user = new User();
		Calendar instance = Calendar.getInstance();
		instance.set(1992, 04, 30);
		Date date = instance.getTime();
		user.setDateOfBirth(date);
		user.setEmail("deveshgupta192@gmail.com");
		user.setName("Devesh Kumar Gupta");
		session.save(user);
		
		Message message = session.get(Message.class, 1L);
	
		Message nextMessage = new Message();
		nextMessage.setText("Three");
		message.setNextMessage(nextMessage);
		session.save(nextMessage);
		session.save(message);
		session.getTransaction().commit();
		session.close();
		sessionFactory.close();
	}
}
