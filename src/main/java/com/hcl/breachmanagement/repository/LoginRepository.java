package com.hcl.breachmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hcl.breachmanagement.entity.User;




public interface LoginRepository extends JpaRepository<User, Long> {
	
@Query(value = "select * from user where user_id=?1 and ph_num=?2 ",nativeQuery = true)
	User findUserByUserIdAndPhNum(Long userId, String phNum);

User findUserByPhNumAndOtp(String phNum, Long otp);

}
