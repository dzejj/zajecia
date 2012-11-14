package registerOffice;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import registerOffice.businessObjects.cars.Car;
import registerOffice.businessObjects.cars.PersonCar;
import registerOffice.businessObjects.persons.*;
import registerOffice.management.HibernatePersonManager;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		//session.beginTransaction();
//		
//		//
//		Car c = new PersonCar("BMW","GDA12345");
//		Person adam = new Person("Adam","1234");
//		adam.getCars().add(c);
//		c.setOwner(adam);
//		//
//	
//		session.persist(adam);
//		
//		
//		List<Person> persons=session.getNamedQuery("allPersonsByName")
//				.setString("name", "Adam").list();
//		
//		for(Person p : persons)
//			System.out.println(p.getName());
//		session.getTransaction().commit();
//		session.close();
		
		HibernatePersonManager mgr = new HibernatePersonManager(session);
		mgr.save(new Person("Adam","1234"));
		mgr.save(new Person("Michal","1234"));
		mgr.save(new Person("Paweł","1234"));
		Person person =new Person("Adam");
		person.setId(10);
		mgr.delete(person);
		//session.getTransaction().commit();
		for(Person p: mgr.getAll())
		{
			System.out.println(p.getName());
		}
		HibernateAddressManager ul = new HibernateAddressManager(session);
		ul.save(new Address("klonowa","1234"));
		ul.save(new Address("jesienna","1234"));
		ul.save(new Address("jakastam","1234"));
		Address address =new Address("klonowa");
		address.setId(10);
		ul.delete(person);
		//session.getTransaction().commit();
		for(Person p: mgr.getAll())
		{
			System.out.println(p.getName());
		}
		session.close();
		//System.out.println("Osoba o id 4:"+mgr.get(4).getName());
		
	}

}
