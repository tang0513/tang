package com.txy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.txy.entity.Roll;
import com.txy.entity.User;
import com.txy.entity.Ztree;
import com.txy.mapper.UserMapper;

@Service
public class UserService {

	@Autowired
	private UserMapper userMapper;

	public List<User> findUserAll() {
		// TODO Auto-generated method stub
		return userMapper.findUserAll();
	}

	public List<Roll> findRollList(Roll roll) {
		// TODO Auto-generated method stub
		return userMapper.findRollList(roll);
	}

	public User findUserOneByUsername(String username) {
		// TODO Auto-generated method stub
		return userMapper.findUserOneByUsername(username);
	}

	public List<Roll> findSessList() {
		// TODO Auto-generated method stub
		return userMapper.findSessList();
	}

	public Roll findSessOneBySname(Roll roll) {
		// TODO Auto-generated method stub
		return userMapper.findSessOneBySname(roll);
	}

	public Roll findRollByStuName(Roll roll) {
		return userMapper.findRollByStuName(roll);
	}

	public void add(Roll roll) {
		// TODO Auto-generated method stub
		userMapper.add(roll);
	}

	public List<Roll> findSessListBySname(Roll roll) {
		// TODO Auto-generated method stub
		return userMapper.findSessListBySname(roll);
	}

	public List<Roll> findSessAll() {
		// TODO Auto-generated method stub
		return userMapper.findSessList();
	}

	public void addSess(Roll roll) {
		// TODO Auto-generated method stub
		userMapper.addSess(roll);
	}

	public Roll findRollBySid(Integer rid) {
		// TODO Auto-generated method stub
		return userMapper.findRollBySid(rid);
	}

	public void update(Roll roll) {
		// TODO Auto-generated method stub
		userMapper.update(roll);
	}

	public void del(Integer rid) {
		// TODO Auto-generated method stub
		userMapper.del(rid);
	}

	public List<Roll> findRollAll() {
		// TODO Auto-generated method stub
		return userMapper.findRollAll();
	}

	public List<Ztree> findZtreeAll() {
		// TODO Auto-generated method stub
		return userMapper.findZtreeAll();
	}
	
}
