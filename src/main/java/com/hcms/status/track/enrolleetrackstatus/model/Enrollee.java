package com.hcms.status.track.enrolleetrackstatus.model;

import java.time.LocalDate;

public class Enrollee {
	private String id;

	private String name;

	private boolean status;

	private LocalDate birthDate;

	private String primaryEnrolleeId;

	private long phoneNumber;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getPrimaryEnrolleeId() {
		return primaryEnrolleeId;
	}

	public void setPrimaryEnrolleeId(String primaryEnrolleeId) {
		this.primaryEnrolleeId = primaryEnrolleeId;
	}

	public long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}
	
	
}
