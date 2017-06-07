package com.squapl.sa.web.api;

	import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.squapl.sa.domain.User;
import com.squapl.sa.service.UserService;

	@RestController
	@RequestMapping("/api")
	public class UserRestController {
		private static final Logger logger = LoggerFactory.getLogger(UserRestController.class);
		
		
	@Autowired
	UserService userService;
		
		@GetMapping(value="/getusers/all",
				produces=MediaType.APPLICATION_JSON_VALUE)
		@CrossOrigin(origins= "http://localhost:4200")
		public ResponseEntity<Iterable<User>> findall(){
			
			
			Iterable<User> users = userService.findUserList();
			
			return new ResponseEntity<Iterable<User>>(users,HttpStatus.OK);
			
		}
		
	}
