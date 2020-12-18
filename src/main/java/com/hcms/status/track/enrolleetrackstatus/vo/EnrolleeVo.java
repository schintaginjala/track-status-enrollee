package com.hcms.status.track.enrolleetrackstatus.vo;

import java.io.Serializable;

public class EnrolleeVo implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public EnrolleeVo() {
		
	}
	
	private String id;
	
	private String name;
	
	private String status;
	
	private String birthDate;
	
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
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
	
	

}
