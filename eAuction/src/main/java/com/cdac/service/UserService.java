package com.cdac.service;

import java.util.List;
import java.util.Optional;

import com.cdac.dto.User;

public interface UserService {
	public void addUser(User user);
	public void removeUser(int userId);
	public Optional<User> getUser(int userId);
	public void modifyUser(User user);
	public List<User> getAll();
	public User fetchByEmailAndPassword(String email, String password);
}
