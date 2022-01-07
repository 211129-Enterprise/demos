package com.revature.classes;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="customer")
public abstract class Person {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="first_name", columnDefinition="VARCHAR(20)")
	private String firstName;
	
	@Column(name="middle_initial", columnDefinition="VARCHAR(1)")
	private String middleInitial;
	
	@Column(name="last_name", columnDefinition="VARCHAR(25)")
	private String lastName;
	
	@Column(name ="acc_ranking", columnDefinition="Number(1,0)", updatable=false)
	private int accountRanking;
	
	@Column(name ="credit_check")
	private int creditCheck;
	
	@Column(name="social_security", updatable=false, columnDefinition="VARCHAR(9)", unique=true)
	private String socialSecurity;
	
	@Column(name="user_name", columnDefinition="VARCHAR(15)", unique=true)
	private String userName;
	
	@Column(name="pwd", columnDefinition="VARCHAR(25)")
	private String passWord; 
	
	@Column(name="active", updatable=true, columnDefinition="BOOLEAN", nullable=false)
	private Boolean active;
	
	//General Constructor============================================================================
	public Person() {
	}
	public Person(int id, String firstName, String middleInitial, String lastName, int accountRanking,
			int creditCheck, String socialSecurity2, String userName, String passWord, boolean active) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.middleInitial = middleInitial;
		this.lastName = lastName;
		this.accountRanking = accountRanking;
		this.creditCheck = creditCheck;
		this.socialSecurity = socialSecurity2;
		this.userName = userName;
		this.passWord = passWord;
		this.active = active;
	}
	
	//toString ============================================================================================
	@Override
	public String toString() {
		return "id=" + id + ", firstName=" + firstName + ", middleInitial=" + middleInitial + ", lastName="
				+ lastName + ", creditCheck=" + creditCheck + ", socialSecurity=" + socialSecurity + ", userName="
				+ userName + ", passWord=" + passWord + ", active=" + active + "";
	}
	
	//Getters and Setters ===============================================================================
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public boolean isActive() {
		return active;
	}
	public boolean setActive(boolean active) {
		return active;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getMiddleInitial() {
		return middleInitial;
	}
	public void setMiddleInitial(String middleInitial) {
		this.middleInitial = middleInitial;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getAccountRanking() {
		return accountRanking;
	}
	public void setAccountRanking(int accountRanking) {
		this.accountRanking = accountRanking;
	}
	public int getCreditCheck() {
		return creditCheck;
	}
	public void setCreditCheck(int creditCheck) {
		this.creditCheck = creditCheck;
	}
	public String getSocialSecurity() {
		return socialSecurity;
	}
	public void setSocialSecurity(String socialSecurity1) {
		this.socialSecurity = socialSecurity1;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	
	
	//Hashcode and equals========================================================================================
	@Override
	public int hashCode() {
		return Objects.hash(active, creditCheck, firstName, id, lastName, middleInitial, passWord, socialSecurity,
				userName);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		return active == other.active && creditCheck == other.creditCheck && Objects.equals(firstName, other.firstName)
				&& id == other.id && Objects.equals(lastName, other.lastName)
				&& Objects.equals(middleInitial, other.middleInitial) && Objects.equals(passWord, other.passWord)
				&& Objects.equals(socialSecurity, other.socialSecurity) && Objects.equals(userName, other.userName);
	}
}
