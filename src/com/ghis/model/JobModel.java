package com.ghis.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class JobModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="JOB_ID")
	private Long id;
	
	@Column(name="JOB_TITLE")
	private String jobTitle;
	
	@Column(name="JOB_EXP")
	private String neededExperience;
	
	@Column(name="JOB_DESC")
	private String description;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public String getNeededExperience() {
		return neededExperience;
	}

	public void setNeededExperience(String neededExperience) {
		this.neededExperience = neededExperience;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
