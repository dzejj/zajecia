package registerOffice.management;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import registerOffice.businessObjects.persons.Address;
import registerOffice.businessObjects.persons.Person;

public abstract class HibernateAddressManager implements ManagerInterface<Address>{

	private Session session;
	
	public HibernateAddressManager( Session session)
	{
		this.session = session;
	}
	
	@Override
	public Address get(int id) {
		
		List<Address> result = this.session.getNamedQuery("allAddressById")
				.setInteger("Id",id).list();
		
		return result.get(0);
	}

	@Override
	public List<Address> getAll() {
		
		return (List<Address>)this.session.getNamedQuery("allAddresses").list();
	}

	@Override
	public boolean save(Address obj) {
		try{
			this.session.beginTransaction();
			this.session.save(obj);
			
			session.beginTransaction().commit();
			return true;
		}catch(Exception ex)
		{
			return false;
		}
	}

	@Override
	public boolean delete(Address obj) {
		try{
			this.session.beginTransaction();
			this.session.getNamedQuery("deleteFromAddress")
			.setInteger("id", obj.getId())
			.executeUpdate();
			this.session.getTransaction().commit();
			return true;
		}
		catch(Exception ex)
		{
			return false;
		}
	}

}
