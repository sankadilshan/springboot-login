package com.itamp.ServiceImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itamp.Model.User;
import com.itamp.Repository.Repository;

@Service
@Transactional
public class ServiceImpl implements com.itamp.Service.Service {
	
	@Autowired
	Repository repository;

	@Override
	public User user(User user) {
		// TODO Auto-generated method stub
		return repository.save(user);
		
	}
	@Override
	public User loginUser(String username, String password) {
		// TODO Auto-generated method stub
		User user= this.repository.findOne(username);
		if(user !=null && user.getPassword().equals(password)) {
			return user;
		}
		return null;
	}
	@Override
	public List findAll() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}	

}
