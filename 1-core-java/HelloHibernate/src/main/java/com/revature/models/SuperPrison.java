package com.revature.models;

import java.util.ArrayList;
import java.util.List;

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
	
	@OneToMany(mappedBy="superPrisonHolder", fetch=FetchType.LAZY)
	private List<SuperVillain> villList = new ArrayList<SuperVillain>();

	public SuperPrison() {
		super();
	}
	
	

	public SuperPrison(String name, String location) {
		super();
		this.name = name;
		this.location = location;
	}



	public SuperPrison(String name, String location, List<SuperVillain> villList) {
		super();
		this.name = name;
		this.location = location;
		this.villList = villList;
	}

	public SuperPrison(int spId, String name, String location, List<SuperVillain> villList) {
		super();
		this.spId = spId;
		this.name = name;
		this.location = location;
		this.villList = villList;
	}
	
}
