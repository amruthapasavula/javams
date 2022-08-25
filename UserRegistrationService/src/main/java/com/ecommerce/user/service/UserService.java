package com.ecommerce.user.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.user.dto.RegesterUserDto;
import com.ecommerce.user.model.User;
import com.ecommerce.user.repository.UserDAORepository;

@Service
public class UserService implements UserServiceRepository {

	@Autowired
	private UserDAORepository userDaoRepo;
	User user = new User();

	public UserService(UserDAORepository userDaoRepo) {
		super();
		this.userDaoRepo = userDaoRepo;
	}

	public String saveUserDetails(RegesterUserDto userDto) {
		if (userDto.getEmail() == null || userDto.getPassword() == null) {
			return "please enter the correct user details ";
		}

		else if (userDaoRepo.existsByEmail(userDto.getEmail())==(true))// Boolean.TRUE.equals(<boolean
																					// variable>)
		{
			return "The Email is already taken...!!";
		} else {
			
			BeanUtils.copyProperties(userDto, user);
			user.setPassword(userDto.getPassword());
			userDaoRepo.save(user);
			BeanUtils.copyProperties(user, userDto);
			return "User regestered Scuccessfully";
		}
	}

	public List<User> getUserDetails() {
		return userDaoRepo.findAll();
	}

	public User getUserById(Long id) {

		return userDaoRepo.findById(id).orElse(null);
	}


	public String deleteUser(Long id) {
		userDaoRepo.deleteById(id);
		return "deleted";
	}
	// update UserDetails

	public String updateUserDetails(RegesterUserDto udto, Long id) {
		Optional<User> user= userDaoRepo.findById(id);
		if(user.isPresent())
		{
		User exuser =user.get();
		
		exuser.setUserId(id);
		exuser.setAddress(udto.getAddress());
		exuser.setMobileno(udto.getMobileno());
		exuser.setEmail(udto.getEmail());
		exuser.setFname(udto.getFname());
		exuser.setLname(udto.getLname());
		exuser.setPassword((udto.getPassword()));
		userDaoRepo.save(exuser);
		return "user details updated successfully";
		}
		else
		{
			return "user not exist";
		}
	}
	
	
	public User getUserByEmail(String email) {
		return userDaoRepo.findByEmail(email).orElse(null);
	}

}