package com.hcl.breachmanagement.service;

import java.util.List;

import com.hcl.breachmanagement.dto.BreachDTO;
import com.hcl.breachmanagement.dto.BreachResponsDTO;

public interface BreachService {
	
	public BreachDTO createBreach(BreachDTO breack);	
	public List<BreachResponsDTO> getBreachByBrechId(Long userid);
	public List<BreachResponsDTO> getAllBreach();
	public  BreachResponsDTO updateBreachStatus(Long breachId,String status);

}
