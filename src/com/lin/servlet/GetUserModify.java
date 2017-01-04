package com.lin.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.maiba.MyDataBase;
import cn.maiba.User;
import cn.maiba.UserLevel;
import cn.maiba.UserType;

/**
 * Servlet implementation class GetUserModify
 */
public class GetUserModify extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetUserModify() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int userId = Integer.parseInt(request.getParameter("userId"));
		User user = (User)MyDataBase.load(User.class, userId);
		int value = user.getValue();
		String modtip = (String)request.getAttribute("ModTip");
		request.setAttribute("ModTip", modtip);
		request.setAttribute("user1", user);
		List typeList = MyDataBase.select(UserType.class, "id");
		int num = typeList.size();
		UserType[] types = new UserType[num];
		for(int i=0; i<num; i++){
				types[i] = (UserType)typeList.get(i);
		}
		request.setAttribute("typeList", types);
		List levellsit = MyDataBase.select(UserLevel.class,"id>"+value+" limit 1");
		request.setAttribute("userLevel",levellsit.get(0));
		request.getRequestDispatcher("/login/UserModify.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int userId = Integer.parseInt(request.getParameter("userId"));
		User user = (User)MyDataBase.load(User.class, userId);
		int value = user.getValue();
		String modtip = (String)request.getAttribute("ModTip");
		request.setAttribute("ModTip", modtip);
		request.setAttribute("user1", user);
		List typeList = MyDataBase.select(UserType.class, "id");
		int num = typeList.size();
		UserType[] types = new UserType[num];
		for(int i=0; i<num; i++){
				types[i] = (UserType)typeList.get(i);
		}
		request.setAttribute("typeList", types);
		request.setAttribute("userLevel", (MyDataBase.select(UserLevel.class,"id>"+value+" limit 1").get(0)));
		request.getRequestDispatcher("/login/UserModify.jsp").forward(request, response);
	}

}
