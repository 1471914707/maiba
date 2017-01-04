package com.lin.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.maiba.MyDataBase;
import cn.maiba.User;

/**
 * Servlet implementation class HandleDelete
 */
public class HandleDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HandleDelete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		int userId = Integer.parseInt(request.getParameter("userId"));
		User user1 = (User)session.getAttribute("user");
		if (user1.getId() == userId){
			request.setAttribute("Result_TYPE", 5);
			request.setAttribute("Result_Message", "不允许删除自己！");
			request.getRequestDispatcher("/ErrorTip.jsp").forward(request, response);
			return ;
		}else{
			if (MyDataBase.delete(User.class,userId)){
				request.setAttribute("Result_TYPE", 4);
				request.setAttribute("Result_Message", "删除用户成功！！");
				request.getRequestDispatcher("/ErrorTip.jsp").forward(request, response);
				return ;
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
