package com.revature.models;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;

import java.util.List;
import java.util.ListIterator;
import java.util.Objects;
import com.revature.annotations.Column;
import com.revature.annotations.Entity;
import com.revature.annotations.Id;
import com.revature.annotations.JoinColumn;


@Entity(tableName = "accounts")
public class Checking implements Serializable, List<Checking>  {
	
	private static final long serialVersionUID = 1098420551338136533L;
	
	
	@Id(columnName="id")
	private int id;
	
	@Column(columnName="active")
	private Boolean active;
	
	@Column(columnName="balance")
	private double balance;
	
	@Column(columnName="account_number")
	private String number;
	
	@Column(columnName="account_type")
	private AccountType accountType;
	
	@JoinColumn(references = DummyOtherClass.class)
	private DummyOtherClass dummyOtherClass;
	
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
	public Checking(int id, String number, Double balance, AccountType accountType, Boolean isActive) {
		super();
		this.id = id;
		this.active = isActive;
		this.balance = balance;
		this.number = number;
		this.accountType = accountType;
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
