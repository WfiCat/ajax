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
		// 设置请求编码格式
		request.setCharacterEncoding("utf-8");
		// 设置响应编码格式
		response.setCharacterEncoding("utf-8");
		//*********************json
//		response.setContentType("text/html;charset=utf-8");
		
		//*************************xml
		response.setContentType("text/xml;charset=utf-8");
		
		// 获取请求的信息
		String name = request.getParameter("name");
		System.out.println("输入："+name);
		// 处理请求信息
			// 创建业务层对象
			UserService userServiceImp = new UserServiceImp();
			// 调用业务方法
			User user = userServiceImp.findUsersByName(name);
		// 响应处理结果
			System.out.println(response);
			System.err.println(user);
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//json数据类型
//			json(request, response,user);
			//xml 数据类型
			// ajax请求------servlet----请求转发到ajaxXml.jsp
			//xml.jsp----每一行都是一个输出语句
			request.setAttribute("user", user);
			//response.getWriter().write("<user><name>zhnag</name><id>2</id></user>");
			
			request.getRequestDispatcher("ajaxXML.jsp").forward(request, response);
			
		
	}

	/**
	 * 返回类型为json
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
