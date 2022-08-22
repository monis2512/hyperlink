package com.hyperlink.dto;

import java.time.LocalDateTime;

public class ComplaintsDTO {
	
	private Integer id;
	private Integer emp_id;
	private Integer categoryId;
	private String description;
	private String reply;
	private String status;
	private LocalDateTime repliedDate;
	
	public Integer getEmp_id() {
		return emp_id;
	}
	public void setEmp_id(Integer emp_id) {
		this.emp_id = emp_id;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getReply() {
		return reply;
	}
	public void setReply(String reply) {
		this.reply = reply;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public LocalDateTime getRepliedDate() {
		return repliedDate;
	}
	public void setRepliedDate(LocalDateTime repliedDate) {
		this.repliedDate = repliedDate;
	}
	
	

}
