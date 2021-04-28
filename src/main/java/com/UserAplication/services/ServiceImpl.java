package com.UserAplication.services;

import java.util.List;
import java.util.Optional;

import com.UserAplication.userdetails.UserDetails;
import com.UserAplication.repository.Repo;
import org.springframework.beans.factory.annotation.Autowired;

@org.springframework.stereotype.Service
public class ServiceImpl implements Service {

	@Autowired
	private Repo repo;

	@Override
	public UserDetails saveUser(UserDetails user) {

		return repo.save(user);
	}

	@Override
	public List<UserDetails> getAllUserData() {

		return repo.findAll();
	}

	@Override
	public Optional<UserDetails> getUserById(Long id) {

		return repo.findById(id);
	}

	@Override
	public void deleteUserById(Long id) {

		repo.deleteById(id);
	}

	@Override
	public List<UserDetails> findByUserName(String name) {
		return  this.repo.findAllByName(name);

	}
}
