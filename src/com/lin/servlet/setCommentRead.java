package com.lin.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.maiba.Comment;
import cn.maiba.MyDataBase;

/**
 * Servlet implementation class setCommentRead
 */
public class setCommentRead extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public setCommentRead() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("id"));
		int index = Integer.parseInt(request.getParameter("index"));
		Comment comm = (Comment) MyDataBase.load(Comment.class, id);
		comm.setIsread(1);
		MyDataBase.update(comm);
		int count = (int) request.getSession().getAttribute("UnreadCount");
		request.getSession().setAttribute("UnreadCount", count-1);
		response.sendRedirect(request.getContextPath()+"/login/GetUnreadList?index="+index);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
