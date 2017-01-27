package com.softtek.academy.services;

import java.util.List;

import com.softtek.academy.domain.User;

public interface UserService {

	public List<User> getAllUsers();

	public User getUserById(Long id);

	public void createUser();

	public boolean updateUser();

	public void deleteUser();

}
