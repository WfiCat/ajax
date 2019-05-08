package cn.hbeu.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import cn.hbeu.bean.User;
import cn.hbeu.service.UserService;
import cn.hbeu.serviceImp.UserServiceImp;

/**
 * Servlet implementation class UserServlet
 */

public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public UserServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// ������������ʽ
		request.setCharacterEncoding("utf-8");
		// ������Ӧ�����ʽ
		response.setCharacterEncoding("utf-8");
		//*********************json
//		response.setContentType("text/html;charset=utf-8");
		
		//*************************xml
		response.setContentType("text/xml;charset=utf-8");
		
		// ��ȡ�������Ϣ
		String name = request.getParameter("name");
		System.out.println("���룺"+name);
		// ����������Ϣ
			// ����ҵ������
			UserService userServiceImp = new UserServiceImp();
			// ����ҵ�񷽷�
			User user = userServiceImp.findUsersByName(name);
		// ��Ӧ������
			System.out.println(response);
			System.err.println(user);
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//json��������
//			json(request, response,user);
			//xml ��������
			// ajax����------servlet----����ת����ajaxXml.jsp
			//xml.jsp----ÿһ�ж���һ��������
			request.setAttribute("user", user);
			//response.getWriter().write("<user><name>zhnag</name><id>2</id></user>");
			
			request.getRequestDispatcher("ajaxXML.jsp").forward(request, response);
			
		
	}

	/**
	 * ��������Ϊjson
	 * @param request
	 * @param response
	 * @throws IOException 
	 */
	private void json(HttpServletRequest request, HttpServletResponse response,User user) throws IOException {
//		response.getWriter().write("{name:"+"'"+user.getName()+"'"
//		+",id:"+user.getId()+",sex:"+"'"+user.getSex()
//		+"'}");
		response.getWriter().write(new Gson().toJson(user));
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
