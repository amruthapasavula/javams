package com.ecommerce.login.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ecommerce.login.dto.UserDto;
import com.ecommerce.login.model.User;

@Service
public class LoginService {
	
	@Autowired
	RestTemplate restTemplate;
	
	User user;
	public String userLogin(UserDto uDto)
	{
		user=restTemplate.getForObject("http://44.192.91.189:8090/user/email/"+uDto.getEmail(),User.class);
		if(user==null)
		{
			return ("\"Status\": \"User Details Incorrect, Login UnSuccess....\"");
		}
		else if(user.getPassword().equals(uDto.getPassword()))
		{
			return ("\"Status\": \"Login Successfull....\"");
		}
		else 
		{
			return ("\"Status\": \"User Details Incorrect, Login UnSuccess....\"");
		}
	}

}
