package com.aristomobileapi.dao;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aristomobileapi.dto.UserInfo; 
  
@Repository
public interface UserInfoRepository extends JpaRepository<UserInfo, Integer> { 
    Optional<UserInfo> findByLoginName(String username); 
    UserInfo findById(int  userId);
    
}