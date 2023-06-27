package com.application.firststep.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.application.firststep.model.User;



public interface UserRepository extends JpaRepository<User, Long>{
	
	User findByMobileNumber(String mobileNumber);
	User findByEmailId(String email);
	User findByUserName(String userName);
}
