package com.lin.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.maiba.Article;
import cn.maiba.MyDataBase;
import cn.maiba.User;
import cn.maiba.UserLevel;
import cn.maiba.UserType;

/**
 * Servlet implementation class GetUserDetail
 */
public class GetUserDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetUserDetail() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 *///user/GetUserDetail
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int userId = Integer.parseInt(request.getParameter("userId"));
		User user = (User)MyDataBase.load(User.class, userId);
		List list = MyDataBase.select(Article.class, "userId="+userId);
		int value = user.getValue();
		request.setAttribute("user1", user);
		request.setAttribute("list", list);
		request.setAttribute("typename", ((UserType)MyDataBase.load(UserType.class, user.getType())).getName());
		request.setAttribute("userLevel", ((UserLevel)(MyDataBase.select(UserLevel.class,"id>"+value+" limit 1")).get(0)));
		request.getRequestDispatcher("/login/UserDetail.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
