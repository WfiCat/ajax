package cn.hbeu.daoImp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.print.attribute.standard.PresentationDirection;

import cn.hbeu.bean.User;
import cn.hbeu.dao.UserDAO;

public class UserDAOImp implements UserDAO {
	 // JDBC 驱动名及数据库 URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
    static final String DB_URL = "jdbc:mysql://localhost:3306/json";
 
    // 数据库的用户名与密码，需要根据自己的设置
    static final String USER = "root";
    static final String PASS = "root";
	public User findUsersByname(String username) {
		User user = null;
		
		try {
			// 加载驱动
			Class.forName(JDBC_DRIVER);
			// 获取连接对象
			Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
			// 创建sql语句对象
			String sql = "select * from user where username=?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			// 给占位符赋值
			pstmt.setString(1, username);
			// 查询数据库
			ResultSet rst = pstmt.executeQuery();
			if(rst.next()) {
				user = new User();
				user.setId(rst.getInt("id"));
				user.setName(rst.getString("username"));
				user.setSex(rst.getString("sex"));
			}
			// 遍历结果集
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return user;
	}


}
