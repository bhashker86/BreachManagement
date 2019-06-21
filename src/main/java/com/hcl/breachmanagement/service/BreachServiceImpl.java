package com.hcl.breachmanagement.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.breachmanagement.dto.BreachDTO;
import com.hcl.breachmanagement.dto.BreachResponsDTO;
import com.hcl.breachmanagement.entity.Breach;
import com.hcl.breachmanagement.repository.BreachRepository;


@Service
public class BreachServiceImpl  implements BreachService{
	
	
	@Autowired
    private BreachRepository breachRepository;	
	
	public BreachDTO createBreach(BreachDTO breach) {
		
		Breach breachEntity=new Breach();
		breachEntity.setBusinessCategory(breach.getBusinessCategory());
		breachEntity.setDescription(breach.getDescription());
		breachEntity.setRisk(breach.getRisk());
		breachEntity.setStatus("Pending");
		breachEntity.setUserId(breach.getUserId());
		
		Breach beach=breachRepository.save(breachEntity);
		
		BreachDTO responseBreachDTO=new BreachDTO(); 
		responseBreachDTO.setBusinessCategory(beach.getBusinessCategory());
		responseBreachDTO.setDescription(beach.getDescription());
		responseBreachDTO.setRisk(beach.getRisk());
		responseBreachDTO.setStatus(beach.getStatus());
		responseBreachDTO.setUserId(beach.getUserId());
		
		return responseBreachDTO;
		
	}
	
	public List<BreachResponsDTO> getBreachByBrechId(Long userid) {
		 List<Breach> breachList=new ArrayList<>();
		 
		 breachRepository.findByUserId(userid).forEach(v->breachList.add(v));
		  
		  List<BreachResponsDTO> breachDtoList=new ArrayList<>();
		  
		  for( Breach breach:breachList) {
				  
			    BreachResponsDTO BreachResponsDTO=new  BreachResponsDTO();
			    BreachResponsDTO.setBusinessCategory(breach.getBusinessCategory());
			    BreachResponsDTO.setDescription(breach.getDescription());
			    BreachResponsDTO.setRisk(breach.getRisk());
			    BreachResponsDTO.setStatus(breach.getStatus());
			    BreachResponsDTO.setUserId(breach.getUserId());
			    BreachResponsDTO.setBreachId(breach.getBreachId());
				
			    breachDtoList.add(BreachResponsDTO);
		    }
		  
		  return  breachDtoList;
		}


	public List<BreachResponsDTO> getAllBreach(){
	  List<Breach> breachList=new ArrayList<>();
	  breachRepository.findAll().forEach(v->breachList.add(v));
	  
	  List<BreachResponsDTO> breachDtoList=new ArrayList<>();
	  for( Breach breach:breachList) {
			  
		    BreachResponsDTO BreachResponsDTO=new  BreachResponsDTO();
		    BreachResponsDTO.setBusinessCategory(breach.getBusinessCategory());
		    BreachResponsDTO.setDescription(breach.getDescription());
		    BreachResponsDTO.setRisk(breach.getRisk());
		    BreachResponsDTO.setStatus(breach.getStatus());
		    BreachResponsDTO.setUserId(breach.getUserId());
		    BreachResponsDTO.setBreachId(breach.getBreachId());
			
		    breachDtoList.add(BreachResponsDTO);
	    }
	  
	  return  breachDtoList;

	}
	
	public  BreachResponsDTO updateBreachStatus(Long breach_id,String status) {
		
		Breach breach=breachRepository.findById(breach_id).get();
		breach.setStatus(status);
		
		Breach breach_response= breachRepository.save(breach);
		
		BreachResponsDTO breachResponsDTO =new BreachResponsDTO();
		
		breachResponsDTO.setBreachId(breach_response.getBreachId());
		breachResponsDTO.setBusinessCategory(breach_response.getBusinessCategory());
		breachResponsDTO.setDescription(breach_response.getDescription());
		breachResponsDTO.setRisk(breach_response.getRisk());
		breachResponsDTO.setStatus(breach_response.getStatus());
		breachResponsDTO.setUserId(breach_response.getUserId());
		
		return breachResponsDTO;
		
	}

	
	
	
	


}
