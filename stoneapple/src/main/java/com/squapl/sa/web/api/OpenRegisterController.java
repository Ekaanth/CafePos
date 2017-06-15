package com.squapl.sa.web.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import com.squapl.sa.domain.OpenRegister;
import com.squapl.sa.service.OpenRegisterService;

@Controller
public class OpenRegisterController {
	
	
	@Autowired
	OpenRegisterService openregisterservice;
	
	
	public ResponseEntity<OpenRegister> saveRegistery(){
		return null;
		
	}
	

}
