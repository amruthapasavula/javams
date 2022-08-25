package com.ecommerce.user.service;

import java.util.List;


import com.ecommerce.user.dto.RegesterUserDto;
import com.ecommerce.user.model.User;


public interface UserServiceRepository {
	//SaveUserDetails
	String saveUserDetails(RegesterUserDto user);
	
	//GetAll User Details
	List<User> getUserDetails();
	
	//Get User Details By Id
	User getUserById(Long id);
	
	User getUserByEmail(String email);
	
	//UpdateUserdetails
	String updateUserDetails(RegesterUserDto user,Long id);
	
	
	//delete User
	String deleteUser(Long id);
	
}
