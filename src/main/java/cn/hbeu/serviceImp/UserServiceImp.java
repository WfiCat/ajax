package cn.hbeu.serviceImp;

import cn.hbeu.bean.User;
import cn.hbeu.dao.UserDAO;
import cn.hbeu.daoImp.UserDAOImp;

public class UserServiceImp implements cn.hbeu.service.UserService {
	
	public User findUsersByName(String name) {
		// �����־ò����
		UserDAO usrDao = new UserDAOImp();
		
		// ���ó־ò㷽��
		return usrDao.findUsersByname(name);
	}

}
