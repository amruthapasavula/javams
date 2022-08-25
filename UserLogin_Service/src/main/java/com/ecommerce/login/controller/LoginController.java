package com.ecommerce.login.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.ecommerce.login.dto.UserDto;
import com.ecommerce.login.model.User;

@RestController
@RequestMapping("/login")
public class LoginController {
	
	@Autowired
	RestTemplate restTemplate;
	
	User user;
	
	@PostMapping("/user")
	public ResponseEntity<String> userLogin(@RequestBody UserDto uDto)
	{
		user=restTemplate.getForObject("http://USERREGESTRATION-SERVICE/user/email/"+uDto.getEmail(),User.class);
		if(user==null)
		{
			return new ResponseEntity<>("\"Status\": \"User Details Incorrect, Login UnSuccess....\"", HttpStatus.UNAUTHORIZED);
		}
		else if(user.getPassword().equals(uDto.getPassword()))
		{
			return new ResponseEntity<>("\"Status\": \"Login Successfull....\"", HttpStatus.OK);
		}
		else 
		{
			return new ResponseEntity<>("\"Status\": \"User Details Incorrect, Login UnSuccess....\"", HttpStatus.UNAUTHORIZED);
		}
				
	}


				
	

}
