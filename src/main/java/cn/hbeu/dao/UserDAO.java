package cn.hbeu.dao;

import cn.hbeu.bean.User;

public interface UserDAO {
	User findUsersByname(String username);
}
