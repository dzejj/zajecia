package registerOffice.businessObjects.persons;

import java.util.*;

import registerOffice.businessObjects.cars.Car;

class CarsList implements Collection<Car>{

	private List<Address> address=new ArrayList<Address>();
	private Person owner;
	
	public void AddressList(Person owner)
	{
		this.owner=owner;
	}
	
	@Override
	public int size() {
		return address.size();
	}

	@Override
	public boolean isEmpty() {
	
		return address.isEmpty();
	}

	@Override
	public boolean contains(Object o) {
		// TODO Auto-generated method stub
		return address.contains(o);
	}

	@Override
	public Iterator<Address> iterator() {
		// TODO Auto-generated method stub
		return address.iterator();
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return cars.toArray();
	}

	@Override
	public <T> T[] toArray(T[] a) {
		// TODO Auto-generated method stub
		return cars.toArray(a);
	}

	@Override
	public boolean add(Car e) {
		// TODO Auto-generated method stub
		e.setOwner(owner);
		return cars.add(e);
	}

	@Override
	public boolean remove(Object o) {
		// TODO Auto-generated method stub
		return cars.remove(o);
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return cars.containsAll(c);
	}

	@Override
	public boolean addAll(Collection<? extends Car> c) {
		
		for(Car car : cars)
		{
			car.setOwner(owner);
		}
		
		return cars.addAll(c);
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return cars.removeAll(c);
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return cars.retainAll(c);
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		cars.clear();
	}

	

}
