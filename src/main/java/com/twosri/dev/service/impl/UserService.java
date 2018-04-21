package com.twosri.dev.service.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.twosri.dev.bean.User;
import com.twosri.dev.database.model.UserEntity;
import com.twosri.dev.database.repository.UserRepository;
import com.twosri.dev.service.IUserService;

@Service
public class UserService implements IUserService {

	@Autowired
	UserRepository repository;

	
	@Autowired
	ModelMapper mMapper;

	@Override
	public void delete(User deleted) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User findOne(String id) {
		UserEntity entity = repository.findOne(id);
		return mMapper.map(entity, User.class);
	}

	@Override
	public User save(User saved) {
		UserEntity entity = repository.save(mMapper.map(saved, UserEntity.class));
		return mMapper.map(entity, User.class);
	}

}
