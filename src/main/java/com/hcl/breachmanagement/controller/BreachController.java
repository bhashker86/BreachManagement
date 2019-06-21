package com.hcl.breachmanagement.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.breachmanagement.dto.BreachDTO;
import com.hcl.breachmanagement.dto.BreachResponsDTO;
import com.hcl.breachmanagement.service.BreachService;

//ip:http://10.117.189.33:8080/breachmanagement/swagger-ui.html

@RestController
@RequestMapping("/api")
@CrossOrigin(allowedHeaders= {"*", "*/"}, origins = {"*", "*/"})
public class BreachController {
	
	
	
	@Autowired
	private BreachService breachService;
	
	
	@PostMapping(value="/submit")
	public ResponseEntity<Object> createtBreach(@RequestBody  BreachDTO breach ){
		
	 	
	   return new 	ResponseEntity<>(breachService.createBreach(breach)  ,HttpStatus.CREATED);
	}
		
	@GetMapping(value="/breachDetails/{userId}")
	public ResponseEntity<List<BreachResponsDTO>> getBreach(@PathVariable("userId") Long userId){
	   return new 	ResponseEntity<>(breachService.getBreachByBrechId(userId)  ,HttpStatus.OK);
	}
	
	@GetMapping(value="/breaches")
	public ResponseEntity<List<BreachResponsDTO>> getAllSBreach(){
		   return new 	ResponseEntity<>(breachService.getAllBreach()  ,HttpStatus.OK);
	}
		
	@GetMapping(value="/approve/{breachId}/{status}")
	public ResponseEntity<BreachResponsDTO> approveBreach(@PathVariable("breachId") Long breachId,@PathVariable("status") String status){
		   return new 	ResponseEntity<>(breachService.updateBreachStatus(breachId, status)  ,HttpStatus.OK);
	}
	
	

}
