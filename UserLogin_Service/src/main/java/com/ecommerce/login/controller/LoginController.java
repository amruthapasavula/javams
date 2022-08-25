package com.ecommerce.login.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.login.dto.UserDto;
import com.ecommerce.login.service.LoginService;

@RestController
@RequestMapping("/login")
public class LoginController {
	
	@Autowired
	LoginService login;
	
	@PostMapping("/user")
	public ResponseEntity<String> userLogin(@RequestBody UserDto uDto)
	{
		return new ResponseEntity<>(login.userLogin(uDto),HttpStatus.OK);
				
	}


				
	

}
