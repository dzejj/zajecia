package registerOffice.management.conditions;

public abstract class Condition<T> {

	public abstract boolean check(T obj);
}
