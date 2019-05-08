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
	 // JDBC �����������ݿ� URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
    static final String DB_URL = "jdbc:mysql://localhost:3306/json";
 
    // ���ݿ���û��������룬��Ҫ�����Լ�������
    static final String USER = "root";
    static final String PASS = "root";
	public User findUsersByname(String username) {
		User user = null;
		
		try {
			// ��������
			Class.forName(JDBC_DRIVER);
			// ��ȡ���Ӷ���
			Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
			// ����sql������
			String sql = "select * from user where username=?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			// ��ռλ����ֵ
			pstmt.setString(1, username);
			// ��ѯ���ݿ�
			ResultSet rst = pstmt.executeQuery();
			if(rst.next()) {
				user = new User();
				user.setId(rst.getInt("id"));
				user.setName(rst.getString("username"));
				user.setSex(rst.getString("sex"));
			}
			// ���������
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return user;
	}


}
