package com.UserAplication.repository;

import com.UserAplication.userdetails.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface Repo extends JpaRepository<UserDetails, Long>{

    @Query("SELECT u FROM UserDetails u WHERE u.name LIKE %?1%")
    public List<UserDetails> findAllByName(String keyword);


}
