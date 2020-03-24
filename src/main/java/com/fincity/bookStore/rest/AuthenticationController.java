package com.fincity.bookStore.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fincity.bookStore.dto.LoginDTO;
import com.fincity.bookStore.serviceImpl.AuthServiceImpl;

@CrossOrigin(origins = "http://localhost:3000") 
@RestController
@RequestMapping("/book-store/rest/v1.0/auth")
public class AuthenticationController {

	private static final Logger logger = LoggerFactory.getLogger(AuthenticationController.class);

	@Autowired
	AuthServiceImpl authServiceImpl;
	
	@RequestMapping(value = "/login", method = RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<Boolean> loginVerify(@RequestBody LoginDTO loginDto){

		Boolean auth = authServiceImpl.isVerified(loginDto.getUsername(), loginDto.getPassword());
				
		if(auth)
			return ResponseEntity
					.status(HttpStatus.OK)
					.body(true);
		else
			return ResponseEntity
					.status(HttpStatus.UNAUTHORIZED)
					.body(false);
		
	}
}
