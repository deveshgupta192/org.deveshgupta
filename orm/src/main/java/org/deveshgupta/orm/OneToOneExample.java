package org.deveshgupta.orm;

import java.util.Date;

import org.deveshgupta.orm.model.Address;
import org.deveshgupta.orm.model.Gender;
import org.deveshgupta.orm.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class OneToOneExample {

	private static SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

	public static void main(String[] args) {
		new OneToOneExample().execute();
	}

	private void execute() {
		create();
		update();
		detach();
		delete();
		
	}

	private void detach() {
		Session session;
		User user;
		session= sessionFactory.openSession();
		user = session.get(User.class, 1L);
		session.evict(user);
		session.close();
		
		/* detached */
		
		user.setName("devesh @ gmail");
		user.getAddress().setPincode(93002);
		session= sessionFactory.openSession();
		session.beginTransaction();
		session.saveOrUpdate(user);
		session.getTransaction().commit();
		session.close();
	}

	private void update() {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		User user = session.get(User.class, 1L);
		user.getAddress().setPincode(50004);
		user.getAddress().setAddress("NEW ADDRESS");
		session.update(user);
		session.getTransaction().commit();
		session.close();
	}

	private void delete() {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		User user = session.get(User.class, 1L);
		session.delete(user);
		session.getTransaction().commit();
		session.close();
	}

	private void create() {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		User user = newUser("deveshgupta192@gmail.com", "Devesh Kumar Gupta");
		Address address = newAddress("Gravity @ 123", 244302);
		user.setAddress(address);
		session.save(user);
		session.getTransaction().commit();
		session.close();
	}

	private static Address newAddress(String addr, int pincode) {
		Address address = new Address();
		address.setAddress(addr);
		address.setPincode(pincode);
		return address;
	}

	private static User newUser(String email, String name) {
		User user = new User();
		user.setDateOfBirth(new Date());
		user.setEmail(email);
		user.setName(name);
		user.setGender(Gender.MALE);
		return user;
	}
}
