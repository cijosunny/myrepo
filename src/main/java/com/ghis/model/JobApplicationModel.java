package com.ghis.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="JOB_APPLICATION_MODEL")
public class JobApplicationModel {
	@Id
	@Column(name="APPLICATION_ID")
	private String applicationId;
	
	@Column(name="JOB_ID")
	private String jobId;
	
	@Column(name="FIRST_NAME")
	private String firstName;
	
	@Column(name="LAST_NAME")
	private String lastName;
	
	@Column(name="EMAIL")
	private String email;
	
	@Column(name="PHONE")
	private String phone;
	
	@Column(name="SSN")
	private String ssn;
	
	@Column(name="ADDRESS")
	private String address;
	
	@Column(name="QUALIFICATION")
	private String qualification;
	
	@Column(name="LST_UPDATE_TS")
	private String lstUpdatedTs;

	public String getApplicationId() {
		return applicationId;
	}

	public void setApplicationId(String applicationId) {
		this.applicationId = applicationId;
	}

	public String getJobId() {
		return jobId;
	}

	public void setJobId(String jobId) {
		this.jobId = jobId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public String getLstUpdatedTs() {
		return lstUpdatedTs;
	}

	public void setLstUpdatedTs(String lstUpdatedTs) {
		this.lstUpdatedTs = lstUpdatedTs;
	}
	
}
