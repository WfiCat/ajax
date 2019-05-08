package cn.hbeu.service;

import java.util.List;

import cn.hbeu.bean.User;

public interface UserService {
	public User findUsersByName(String name);
}
