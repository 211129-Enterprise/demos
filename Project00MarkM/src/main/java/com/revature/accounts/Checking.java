package com.revature.accounts;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.revature.classes.Administrator;
import com.revature.classes.Customers;
import com.revature.classes.Employee;

@Entity
@Table(name="account")
public class Checking implements Serializable, List<Checking>  {
	
	private static final long serialVersionUID = 1098420551338136533L;
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="active", updatable=true, columnDefinition="BOOLEAN", nullable=false)
	private Boolean active;
	
	@Column(name="balance", columnDefinition="BigInteger(15,2)", updatable=true)
	private double balance;
	
	@Column(name="account_number", updatable=false, unique = true, nullable=false)
	private String number;
	
	@Column(name="account_type", updatable=false)
	private AccountType accountType;
	
	
	private List<Customers> customers = new LinkedList<Customers>();
	
	private List<Employee> employee = new LinkedList<Employee>();
	
	private List<Administrator> administrator = new LinkedList<Administrator>();
	
	
	//Constructors==========================================================================================
	public Checking() {
		super();
	}
	public Checking(int id, String number, double balance, AccountType accountType, boolean active) {
		super();
		this.id = id;
		this.active = active;
		this.balance = balance;
		this.number = number;
		this.accountType = accountType;
	}
	
	//Constructor with fields================================================================================
	public Checking(int id, boolean isActive, double balance, String number, AccountType accountType) {
		super();
		this.id = id;
		this.active = isActive;
		this.balance = balance;
		this.number = number;
		this.accountType = accountType;
	}
	public Checking(int id, String number, Double balance, AccountType accountType, Boolean isActive, List<Customers> customers
			, List<Employee> employee, List<Administrator> administrator) {
		super();
		this.id = id;
		this.active = isActive;
		this.balance = balance;
		this.number = number;
		this.accountType = accountType;
		this.customers = customers;
		this.employee = employee;
		this.administrator = administrator;
	}
	
	//toString===============================================================================================
	@Override
	public String toString() {
		return "Checking [id=" + id + ", isActive=" + active + ", balance=" + balance
				+ ", number=" + number + ", accountType=" + accountType + "]";
	}

	//Getters and Setters ===================================================================================

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean isActive) {
		this.active = isActive;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public AccountType getAccountType() {
		return accountType;
	}
	public void setAccountType(AccountType accountType) {
		this.accountType = accountType;
	}
	public List<Customers> getCustomers() {
		return customers;
	}
	public void setCustomers(List<Customers> customers) {
		this.customers = customers;
	}
	public List<Employee> getEmployee() {
		return employee;
	}
	public void setEmployee(List<Employee> employee) {
		this.employee = employee;
	}
	public List<Administrator> getAdministrator() {
		return administrator;
	}
	public void setAdministrator(List<Administrator> administrator) {
		this.administrator = administrator;
	}
	
	
	//hash code and equals ==================================================================================
	@Override
	public int hashCode() {
		return Objects.hash(accountType, balance, id, active, number);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Checking other = (Checking) obj;
		return accountType == other.accountType
				&& Double.doubleToLongBits(balance) == Double.doubleToLongBits(other.balance) && id == other.id
				&& active == other.active && Objects.equals(number, other.number);
	}
	
	
	
	
	
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean contains(Object o) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public Iterator<Checking> iterator() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public <T> T[] toArray(T[] a) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public boolean add(Checking e) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean remove(Object o) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean containsAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean addAll(Collection<? extends Checking> c) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean addAll(int index, Collection<? extends Checking> c) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean removeAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean retainAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public Checking get(int index) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Checking set(int index, Checking element) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void add(int index, Checking element) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public Checking remove(int index) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public int indexOf(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int lastIndexOf(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public ListIterator<Checking> listIterator() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ListIterator<Checking> listIterator(int index) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<Checking> subList(int fromIndex, int toIndex) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

	



	
	
	
	
	
}
