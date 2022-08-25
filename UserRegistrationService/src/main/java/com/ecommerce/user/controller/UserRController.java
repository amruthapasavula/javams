package com.ecommerce.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.user.dto.RegesterUserDto;
import com.ecommerce.user.model.User;
import com.ecommerce.user.service.UserServiceRepository;


@RestController
@RequestMapping("/user")
public class UserRController {

		
		@Autowired
		private UserServiceRepository userServiceRepo;

		

		public UserRController( UserServiceRepository userServiceRepo) {
			super();
			this.userServiceRepo = userServiceRepo;
		}

		@PostMapping("/regesterUser")
		public ResponseEntity<String> saveUserDetailss(@RequestBody RegesterUserDto user) {
			return new ResponseEntity<>(userServiceRepo.saveUserDetails(user), HttpStatus.CREATED);

		}

		// get all users
		@GetMapping("/users")
		public ResponseEntity<List<User>> getAllUsers() {
			return new ResponseEntity<>(userServiceRepo.getUserDetails(), HttpStatus.OK);
		}

		// get user by id
		@GetMapping("/id/{id}")
		public ResponseEntity<User> getById(@PathVariable Long id) {
//			
			return new ResponseEntity<>(userServiceRepo.getUserById(id), HttpStatus.OK);
			
		}


		// get User By email
		@GetMapping("/email/{email}")
		public ResponseEntity<User> getByEmail(@PathVariable String email) {
			
			return new ResponseEntity<>(userServiceRepo.getUserByEmail(email), HttpStatus.OK);

		}

		// delete user
		@DeleteMapping("/delete/{id}")
		public ResponseEntity<String> deleteUserDetails(@PathVariable Long id) {

			userServiceRepo.deleteUser(id);
			return new ResponseEntity<>("user deleted successfully", HttpStatus.MOVED_PERMANENTLY);
			
		}

		// update userDetails
		@PutMapping("/update/{id}")
		public ResponseEntity<String> updateUserDetails(@RequestBody RegesterUserDto userDto, @PathVariable Long id) {
			
			return new ResponseEntity<>(userServiceRepo.updateUserDetails(userDto, id), HttpStatus.OK);
			
		}
		
			

}
