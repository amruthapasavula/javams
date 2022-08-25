package com.ecommerce.user;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;

import com.ecommerce.user.controller.UserRController;
import com.ecommerce.user.dto.RegesterUserDto;
import com.ecommerce.user.model.User;
import com.ecommerce.user.service.UserServiceRepository;

@TestMethodOrder(OrderAnnotation.class)
@RunWith(SpringRunner.class)
@SpringBootTest
class UserRegistrationServiceApplicationTests {

	@Autowired
	private UserServiceRepository userServiceRepo;
	
	@Autowired
	private UserRController userController;
	
	RegesterUserDto uDto=new RegesterUserDto();
	{
		uDto.setAddress("mp");
		uDto.setEmail("maya@gmail.com");
		uDto.setFname("maya");
		uDto.setLname("sree");
		uDto.setMobileno("9764933832");
		uDto.setPassword("maya123");
		uDto.setUserId(1L);
		uDto.getAddress();uDto.getEmail();uDto.getFname();uDto.getLname();uDto.getMobileno();uDto.getPassword();uDto.getUserId();
		
	}
	
	User user=new User();
	{
		user.setAddress("ap");
		user.setEmail("ram@gmail.com");
		user.setFname("ram");
		user.setLname("krishna");
		user.setMobileno("9783498347");
		user.setPassword("rk123");
		user.setUserId(1L);
		user.getAddress();user.getEmail();user.getFname();user.getLname();user.getMobileno();user.getPassword();user.getUserId();
	}
	@Order(1)
	@Test
	void saveUserDetailsTestPass() {
		assertEquals("User regestered Scuccessfully", userServiceRepo.saveUserDetails(uDto));
	}
	
	@Order(2)
	@Test
	void saveUserDetailsTestFail1()
	{
		assertEquals("The Email is already taken...!!", userServiceRepo.saveUserDetails(uDto));
	}
	
	@Order(3)
	@Test
	void saveUserDetailsTestFail2()
	{
		assertEquals("please enter the correct user details ", userServiceRepo.saveUserDetails(new RegesterUserDto(null,null, null, null, null, null, "")));
	
	}
	
	@Order(4)
	@Test
	void getUserDetails()
	{
		assertEquals(1, userServiceRepo.getUserDetails().size());
	}

	
	@Order(8)
	@Test
	void getUserDetailsById()
	{	
		Long id=1L;
		assertEquals(1L,userServiceRepo.getUserById(id).getUserId());
	}
	
	@Order(9)
	@Test
	void getUserDetailsByIdFail()
	{	
		Long id=12L;
		assertEquals(null,userServiceRepo.getUserById(id));
	}
	
//	@Order(10)
//	@Test
//	void getUserDetailsByEmailPass()
//	{
//		String email1="ram@gmail.com";
//		assertEquals(email1, userServiceRepo.getUserByEmail(email1).getEmail());
//	}
	@Order(11)
	@Test
	void getUserDetailsByEmailFail()
	{
		String email1="jkhsak@gmail.com";
		assertEquals(null, userServiceRepo.getUserByEmail(email1));
	}
	@Order(12)
	@Test
	void updateUserDetailsTest()
	{
		RegesterUserDto u=new RegesterUserDto(1L, "ammu@gmail.com", "amrutha", "p", "ammu@123", "767962962", "ap");
		Long id=1L;
		assertEquals("user details updated successfully", userServiceRepo.updateUserDetails(u, id));
	}
	
	@Order(12)
	@Test
	void updateUserDetailsTestFail()
	{
		RegesterUserDto u=new RegesterUserDto(1L, "ammu@gmail.com", "amrutha", "p", "ammu@123", "767962962", "ap");
		Long id=15L;
		assertEquals("user not exist", userServiceRepo.updateUserDetails(u, id));
	}
	
	@Order(13)
	@Test
	void deleteUserTest()
	{
		Long id=1L;
		assertEquals("deleted", userServiceRepo.deleteUser(id));
	}
	
	@Order(14)
	@Test
	void saveUserDetaisTest()
	{
		assertEquals( HttpStatus.CREATED, userController.saveUserDetailss(uDto).getStatusCode());
	}
	
	@Order(15)
	@Test
	void getAllUsersTest()
	{
		assertEquals(HttpStatus.OK, userController.getAllUsers().getStatusCode());
	}
	
	@Order(16)
	@Test
	void getById()
	{
		Long id=2L;
		assertEquals(HttpStatus.OK, userController.getById(id).getStatusCode());
	}
	
	@Order(17)
	@Test
	void getByEmail()
	{
		String email="ram@gmail.com";
		assertEquals(HttpStatus.OK, userController.getByEmail(email).getStatusCode());
	}
	
	
	@Order(19)
	@Test
	void uupdateTest()
	{
		RegesterUserDto u=new RegesterUserDto(2L, "ammu@gmail.com", "amrutha", "p", "ammu@123", "767962962", "ap");
		Long id=2L;
		assertEquals(HttpStatus.OK, userController.updateUserDetails(u, id).getStatusCode());
	}
	
	@Order(22)
	@Test
	void deleteTest()
	{
		Long id=2L;
		assertEquals(HttpStatus.MOVED_PERMANENTLY, userController.deleteUserDetails(id).getStatusCode());
	}
	
	@Test
	   void applicationStarts() {
		UserRegistrationServiceApplication.main(new String[] {});
	  }
}
