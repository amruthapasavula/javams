package com.ecommerce.user.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.user.model.User;

public interface UserDAORepository extends JpaRepository<User, Long> {

	boolean existsByEmail(String email);

	Optional<User> findByEmail(String email);

	Optional<User> findByFname(String fname);

	Optional<User> findByLname(String lname);

	Optional<User> findByUserId(Long userId);

}
