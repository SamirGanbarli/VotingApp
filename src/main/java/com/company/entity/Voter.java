package com.company.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="voters")
public class Voter {

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Integer id;
	
	@Column(name="voter_name")
	private String voterName;
	
	@Column(name = "has_voted")
	private Boolean hasVoted;

	public Voter() {
		super();
	}

	public Voter(Integer id, String voterName, Boolean hasVoted) {
		super();
		this.id = id;
		this.voterName = voterName;
		this.hasVoted = hasVoted;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getVoterName() {
		return voterName;
	}

	public void setVoterName(String voterName) {
		this.voterName = voterName;
	}

	public Boolean getHasVoted() {
		return hasVoted;
	}

	public void setHasVoted(Boolean hasVoted) {
		this.hasVoted = hasVoted;
	}
	
	

	
}
