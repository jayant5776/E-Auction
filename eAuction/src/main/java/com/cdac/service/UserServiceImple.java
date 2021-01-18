package com.cdac.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdac.dto.User;
import com.cdac.repo.UserRepository;

@Service
public class UserServiceImple implements UserService{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void addUser(User user) {
		userRepository.save(user);
	}

	@Override
	public void removeUser(int userId) {
		userRepository.deleteById(userId);
	}

	@Override
	public Optional<User> getUser(int userId) {
		return userRepository.findById(userId);
	}

	@Override
	public void modifyUser(User user) {
		userRepository.save(user);
	}

	@Override
	public List<User> getAll() {
		Iterable<User> itr = userRepository.findAll();
		Iterator<User> it = itr.iterator();
		List<User> li = new ArrayList<User>();
		while (it.hasNext()) {
			li.add(it.next());
		}
		return li;
	}

	@Override
	public User fetchByEmailAndPassword(String email, String password) {
		User user = userRepository.findByEmailAndPassword(email, password);
		return user;
	}
}
