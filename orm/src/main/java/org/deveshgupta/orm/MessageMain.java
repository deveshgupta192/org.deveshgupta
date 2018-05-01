package org.deveshgupta.orm;

import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

import org.deveshgupta.orm.model.Message;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

/**
 * Hello world!
 *
 */
public class MessageMain {
	
	private static SessionFactory sessionFactory;

	public MessageMain() {
		sessionFactory = HibernateUtil.getSessionFactory();
	}
	
	public static void main(String[] args) {
		MessageMain main = new MessageMain();
		main.execute();
	}

	private void execute() {
		System.out.println("SAVE 10 MESSAGE");
		IntStream.rangeClosed(1,10).forEach(i-> create("Message "+i));
		System.out.println("Update ALL");
		LongStream.range(1,10).forEach(i-> update(i));
		System.out.println("GET ONE");
		Message message = getById(5L);
		System.out.println("GET ALL");
		List<Message> list = getAll();
		System.out.println("DELETE ONE");
		delete(2L);
	}

	private void create(String text) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Message m = new Message();
		m.setText(text);
		m.setNextMessage(null);
		session.save(m);
		session.getTransaction().commit();
		session.close();
	}

	private Message getById(Long id) {
		Session session = sessionFactory.openSession();
		Message message = session.get(Message.class, id);
		System.out.println(message);
		session.close();
		return message;		
	}
	
	private List<Message> getAll() {
		Session session = sessionFactory.openSession();
		Query<Message> query = session.createQuery("from MESSAGE", Message.class);
		List<Message> list = query.getResultList();
		list.forEach(System.out::println);
		session.close();
		return list;		
	}
	
	private void update(Long id) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Message message = session.get(Message.class, id);
		message.setText(message.getText()+String.valueOf(id));
		message.setNextMessage(session.get(Message.class, id+1));
		session.save(message);
		session.getTransaction().commit();
		session.close();		
	}
	
	private void delete(Long messageId) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Query<Message> query = session.createQuery("from MESSAGE", Message.class);
		List<Message> list = query.getResultList();
		list.stream().filter(m -> isNextMessage(messageId, m)).forEach(m -> {
			System.out.println(m);
			m.setNextMessage(null);
			session.update(m);
		});
		Message message = session.get(Message.class, messageId);
		message.setNextMessage(null);
		session.save(message);
		System.out.println(message);
		session.delete(message);
		session.getTransaction().commit();
		session.close();
	}

	private boolean isNextMessage(Long messageId, Message m) {
		return Objects.nonNull(m.getNextMessage()) && Objects.equals(m.getNextMessage().getId(), messageId);
	}
}
