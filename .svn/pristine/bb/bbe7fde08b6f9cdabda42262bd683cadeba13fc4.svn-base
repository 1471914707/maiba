package com.lin.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.maiba.Article;
import cn.maiba.MyDataBase;

/**
 * Servlet implementation class CancelArticleStick
 */
public class CancelArticleStick extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CancelArticleStick() {
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
		article.setStick(0);
		if(MyDataBase.update(article)){
			request.setAttribute("Mess", "取消置顶成功!");
		}else{
			request.setAttribute("Mess", "取消置顶失败！");
		}
		int index = Integer.parseInt(request.getParameter("index"));
		request.getRequestDispatcher("/login/GoModelManage?idnex="+index).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
