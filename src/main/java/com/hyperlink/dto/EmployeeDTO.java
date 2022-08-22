package com.hyperlink.dto;

public class EmployeeDTO {
	
	private Integer id;
	private String name;
	private String photo;
	private Integer mobile;
	private String email;
	private String password;
	private String workingType;
	private String status;
	
	public enum WORKINGTYPE{
		WFH,
		WFO
	}
	
	public enum STATUS{
		ACTIVE,
		INACTIVE,
		BLOCK
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public Integer getMobile() {
		return mobile;
	}

	public void setMobile(Integer mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getWorkingType() {
		return workingType;
	}

	public void setWorkingType(String workingType) {
		this.workingType = workingType;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

//	public WORKINGTYPE getWorkingType() {
//		return workingType;
//	}
//
//	public void setWorkingType(WORKINGTYPE workingType) {
//		this.workingType = workingType;
//	}
//
//	public STATUS getStatus() {
//		return status;
//	}
//
//	public void setStatus(STATUS status) {
//		this.status = status;
//	}
	
	
	

}
