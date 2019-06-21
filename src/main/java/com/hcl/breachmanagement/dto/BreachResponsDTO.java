package com.hcl.breachmanagement.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class BreachResponsDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private Long breachId;
	private Long	userId;
	private String	businessCategory;
	private String	description;
	private String	risk;
	private String	status;
	
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getBusinessCategory() {
		return businessCategory;
	}
	public void setBusinessCategory(String businessCategory) {
		this.businessCategory = businessCategory;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getRisk() {
		return risk;
	}
	public void setRisk(String risk) {
		this.risk = risk;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Long getBreachId() {
		return breachId;
	}
	public void setBreachId(Long breachId) {
		this.breachId = breachId;
	}
	


}
