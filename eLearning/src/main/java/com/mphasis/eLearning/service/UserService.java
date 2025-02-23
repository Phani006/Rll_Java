package com.mphasis.eLearning.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mphasis.eLearning.entity.User;
import com.mphasis.eLearning.repository.UserRepository;
@Service
public class UserService implements IUserService {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public User validate(String email, String password) {
		User user=null;
		user=userRepository.Validate(email, password);
		return user;
	}

	@Override
	public User getUserById(int userId) {
		User user=null;
		if(userRepository.existsById(userId)){
			user=userRepository.findById(userId).get(); 
		}
		return user;
	}

}
