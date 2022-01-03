package com.revature.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="super_villains")
public class SuperVillain {
	@Id
	@Column(name="svill_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int svillId;
	
	@Column(name="svill_name", unique=true, nullable=false)
	private String svillName;
	
	@Column(name="super_power")
	private String superPower;
	
	private double bounty;
	
	@ManyToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private List<Crime> crimes;
	
	
	@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	@JoinColumn(name="prison_fk")
	private SuperPrison superPrisonHolder;
	
	public SuperVillain() {
		
	}

	public SuperVillain(int svillId, String svillName, String superPower, double bounty, List<Crime> crimes,
			SuperPrison superPrisonHolder) {
		super();
		this.svillId = svillId;
		this.svillName = svillName;
		this.superPower = superPower;
		this.bounty = bounty;
		this.crimes = crimes;
		this.superPrisonHolder = superPrisonHolder;
	}

	public SuperVillain(String svillName, String superPower, double bounty, List<Crime> crimes,
			SuperPrison superPrisonHolder) {
		super();
		this.svillName = svillName;
		this.superPower = superPower;
		this.bounty = bounty;
		this.crimes = crimes;
		this.superPrisonHolder = superPrisonHolder;
	}
	
	
}
