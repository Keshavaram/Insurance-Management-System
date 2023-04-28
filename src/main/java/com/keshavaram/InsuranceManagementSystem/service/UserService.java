package com.keshavaram.InsuranceManagementSystem.service;

import com.keshavaram.InsuranceManagementSystem.domain.User;
import com.keshavaram.InsuranceManagementSystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

	public User getUser(String username, String password)
	{
		List<User> allUsers = userRepository.findAll();
		User currentUser = null;
		for(User u : allUsers)
		{
			System.out.println(u.getUsername() + " " + u.getPassword());
			if (u.getUsername().equals(username)){
				if (password != null)
				{
					if (u.getPassword().equals(password))
					{
						currentUser = User.cloneUser(u);
						break;
					}
				} else {
					currentUser = User.cloneUser(u);
					break;
				}
			}
		}
		return currentUser;
	}
    public User login(String username, String password) {
		return getUser(username,password);
    }

    public void register(User user) {
        userRepository.save(user);
    }

    public User findByUsername(String username) {
        return getUser(username,null);
    }

    public void changePassword(User user, String newPassword) {
        user.setPassword(newPassword);
        userRepository.save(user);
    }

}
