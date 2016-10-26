package com.ghis.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="JOB_MODEL")
public class JobModel {
	@Id
	@Column(name="JOB_ID")
	private String jobId;
	
	@Column(name="JOB_TITLE")
	private String jobTitle;
	
	@Column(name="JOB_QUALIFICATION")
	private String neededExperience;
	
	@Column(name="JOB_DESC")
	private String description;
	
	@Column(name="JOB_SALARY")
	private String salary;
	
	@Column(name="LST_UPDATE_TS")
	private String lstUpdatedTs;

	public String getJobId() {
		return jobId;
	}

	public void setJobId(String jobId) {
		this.jobId = jobId;
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

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

	public String getLstUpdatedTs() {
		return lstUpdatedTs;
	}

	public void setLstUpdatedTs(String lstUpdatedTs) {
		this.lstUpdatedTs = lstUpdatedTs;
	}

}
