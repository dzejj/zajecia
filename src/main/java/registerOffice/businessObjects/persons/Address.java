package registerOffice.businessObjects.persons;

import java.util.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

import registerOffice.businessObjects.persons.*;

@NamedQueries({
		@NamedQuery(
					name="allAddressById",
					query="from Address a where a.id= :id " ),
		@NamedQuery(
				name="allAddresses",
				query="from Address a"
				),
		@NamedQuery(
				name="deleteFromAddress",
				query="delete Address where id=:id"
				)})
		
@Entity
@Table(name="OSOBY")
public class Address {

	@Id
	@GeneratedValue
	private int id;
	
	@Column(name="ulica")
	private String name;
	
	@OneToMany(mappedBy="owner", cascade=javax.persistence.CascadeType.PERSIST)
	private Collection<Person> persons;
	private String pesel;
	
	public Address(String name, String pesel)
	{
	
		this.name=name;
	
	}
	
	public Address(String name) {
		
		this(name,"");
	}
	
	public Address()
	{
		this("","");
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Collection<Person> getPerson() {
		return persons;
	}
	public void setCars(List<Person> persons) {
		this.persons = persons;
	}

	public String getPesel() {
		return pesel;
	}

	public void setStreet(String pesel) {
		this.pesel = pesel;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
	
}
