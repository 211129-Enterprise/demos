package com.revature.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="super_prison")
public class SuperPrison {
	
	@Id
	@Column(name="sp_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int spId;
	
	@Column(name="sp_name")
	private String name;
	
	private String location;
	
	// This lists the many villians whose foreign key points to this super prison's primary key
	// One SuperPrison per SuperVillian && many SuperVillians per SuperPrison
	@OneToMany(mappedBy="superPrisonHolder", fetch=FetchType.LAZY) // We are mapping to the property of the SuperVillian class
	private List<SuperVillian> villList = new ArrayList<SuperVillian>();
	
	public SuperPrison(){
		
	}

	public SuperPrison(String name, String location) {
		super();
		this.name = name;
		this.location = location;
	}
	
	public SuperPrison(String name, String location, List<SuperVillian> villList) {
		super();
		this.name = name;
		this.location = location;
		this.villList = villList;
	}

	public SuperPrison(int spId, String name, String location, List<SuperVillian> villList) {
		super();
		this.spId = spId;
		this.name = name;
		this.location = location;
		this.villList = villList;
	}

	public int getSpId() {
		return spId;
	}

	public void setSpId(int spId) {
		this.spId = spId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public List<SuperVillian> getVillList() {
		return villList;
	}

	public void setVillList(List<SuperVillian> villList) {
		this.villList = villList;
	}

	@Override
	public int hashCode() {
		return Objects.hash(location, name, spId, villList);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SuperPrison other = (SuperPrison) obj;
		return Objects.equals(location, other.location) && Objects.equals(name, other.name) && spId == other.spId
				&& Objects.equals(villList, other.villList);
	}

	@Override
	public String toString() {
		return "SuperPrison [spId=" + spId + ", name=" + name + ", location=" + location + ", villList=" + villList
				+ "]";
	}
	
	
	
	
}