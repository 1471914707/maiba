package com.lin.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.maiba.Article;
import cn.maiba.MyDataBase;
import cn.maiba.User;

/**
 * Servlet implementation class AddArticleStick
 */
public class AddArticleStick extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddArticleStick() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("articleId"));
		Article article = (Article)MyDataBase.load(Article.class, id);
		article.setStick(1);
		User user  = (User)MyDataBase.load(User.class, article.getUserId());
		user.setValue(user.getValue()+10); //被置顶的用户会加10积分
		MyDataBase.update(user);
		if(MyDataBase.update(article)){
			request.setAttribute("Mess", "置顶成功!");
		}else{
			request.setAttribute("Mess", "置顶失败！");
		}
		int index = Integer.parseInt(request.getParameter("index"));
		request.getRequestDispatcher("/login/GoModelManage?index="+index).forward(request, response);	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
