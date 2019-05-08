package cn.hbeu.serviceImp;

import cn.hbeu.bean.User;
import cn.hbeu.dao.UserDAO;
import cn.hbeu.daoImp.UserDAOImp;

public class UserServiceImp implements cn.hbeu.service.UserService {
	
	public User findUsersByName(String name) {
		// 创建持久层对象
		UserDAO usrDao = new UserDAOImp();
		
		// 调用持久层方法
		return usrDao.findUsersByname(name);
	}

}
