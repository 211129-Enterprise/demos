package com.revature.models;

import java.util.Objects;

import com.revature.annotations.Column;
import com.revature.annotations.Entity;
import com.revature.annotations.Id;

@Entity(tableName="test_table")
public class DummyOtherClass {

	@Id(columnName="id")
	private int id;
	
	@Column(columnName="first_name")
	private String firstName;
	
	@Column(columnName="middle_initial")
	private String middleInitial;
	
	@Column(columnName="last_name")
	private String lastName;
	
	@Column(columnName ="acc_ranking")
	private int accountRanking;
	
	@Column(columnName ="credit_check")
	private int creditCheck;
	
	@Column(columnName="social_security")
	private String socialSecurity;
	
	@Column(columnName="user_name")
	private String userName;
	
	@Column(columnName="pwd")
	private String passWord; 
	
	@Column(columnName="active")
	private Boolean active;
	
	//Constructors ====================================================================================================================================
	public DummyOtherClass(int id, String firstName, String middleInitial, String lastName, int accountRanking,
			int creditCheck, String socialSecurity, String userName, String passWord, Boolean active) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.middleInitial = middleInitial;
		this.lastName = lastName;
		this.accountRanking = accountRanking;
		this.creditCheck = creditCheck;
		this.socialSecurity = socialSecurity;
		this.userName = userName;
		this.passWord = passWord;
		this.active = active;
	}
	
	//Getters and Setters =============================================================================================================================
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public void setSocialSecurity(String socialSecurity) {
		this.socialSecurity = socialSecurity;
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
	public Boolean getActive() {
		return active;
	}
	public void setActive(Boolean active) {
		this.active = active;
	}

	//toString =========================================================================================================================================
	@Override
	public String toString() {
		return "DummyOtherClass [id=" + id + ", firstName=" + firstName + ", middleInitial=" + middleInitial
				+ ", lastName=" + lastName + ", accountRanking=" + accountRanking + ", creditCheck=" + creditCheck
				+ ", socialSecurity=" + socialSecurity + ", userName=" + userName + ", passWord=" + passWord
				+ ", active=" + active + "]";
	}
	
	//Equals and Hash Code ==============================================================================================================================
	@Override
	public int hashCode() {
		return Objects.hash(accountRanking, active, creditCheck, firstName, id, lastName, middleInitial, passWord,
				socialSecurity, userName);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DummyOtherClass other = (DummyOtherClass) obj;
		return accountRanking == other.accountRanking && Objects.equals(active, other.active)
				&& creditCheck == other.creditCheck && Objects.equals(firstName, other.firstName) && id == other.id
				&& Objects.equals(lastName, other.lastName) && Objects.equals(middleInitial, other.middleInitial)
				&& Objects.equals(passWord, other.passWord) && Objects.equals(socialSecurity, other.socialSecurity)
				&& Objects.equals(userName, other.userName);
	}
	
	
	
}