package com.ecommerce.login;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import com.ecommerce.login.controller.LoginController;
import com.ecommerce.login.dto.UserDto;
import com.ecommerce.login.model.User;
@RunWith(SpringRunner.class)
@SpringBootTest
class UserLoginServiceApplicationTests {
	
	@Autowired
	private LoginController login;
	
	@Autowired
	RestTemplate restTemplate;
	
	UserDto uDto=new UserDto();
	{
		uDto.setEmail("maya@gmail.com");
		uDto.setPassword("maya123");
		uDto.getEmail();
		uDto.getPassword();
	}
	
	User u=new User();
	{
		u.setAddress("ap");
		u.setEmail("am@jfn");
		u.setFname("ammu");
		u.setLname("pp");
		u.setMobileno("234234");
		u.setPassword("dvdwd");
		u.setUserId(1L);
		u.getAddress();
		u.getEmail();
		u.getFname();
		u.getLname();
		u.getMobileno();
		u.getPassword();
		u.getUserId();
	}

	@Test
	void LoginTest() {
		
		assertEquals(HttpStatus.OK, login.userLogin(uDto).getStatusCode());
	}

	@Test
	void LoginTestFail1() {
		uDto.setEmail("jessie@gmail.com");
		uDto.setPassword("maya123");
		assertEquals(HttpStatus.UNAUTHORIZED, login.userLogin(uDto).getStatusCode());
	}
	@Test
	void LoginTestFail2() {
		
		//User user=restTemplate.getForObject("http://localhost:8090/user/email/"+uDto.getEmail(),User.class);
		uDto.setEmail("maya@gmail.com");
		uDto.setPassword("maya1234");
		assertEquals(HttpStatus.UNAUTHORIZED, login.userLogin(uDto).getStatusCode());
	}
	
	@Test
	   void applicationStarts() {
		UserLoginServiceApplication.main(new String[] {});
	  }
}
