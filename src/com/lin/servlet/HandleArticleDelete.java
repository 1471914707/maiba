package com.lin.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.maiba.Article;
import cn.maiba.Comment;
import cn.maiba.MyDataBase;
import cn.maiba.User;

/**
 * Servlet implementation class HandleArticleDelete
 */
public class HandleArticleDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HandleArticleDelete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("articleId"));
		//&& MyDataBase.deleteRow(Article.class,"articleId="+id)
		if (MyDataBase.delete(Article.class, id) ){
			 //删帖扣两积分
			if ( request.getSession().getAttribute("user") != null){
				User user = (User)request.getSession().getAttribute("user");
				user.setValue(user.getValue()-2);
				MyDataBase.update(user);
			}
			request.setAttribute("Result_Message", "删除文章成功！");
			//把文章的评论也删了
			MyDataBase.deleteRow(Article.class, "id="+id);
			
			if (request.getRequestURI().contains("/login/GoModelManage")){
				request.setAttribute("Result_TYPE", 12);
			}else{
				request.setAttribute("Result_TYPE", 13);
			}		
			request.getRequestDispatcher("/ErrorTip.jsp").forward(request, response);
		}else{
			request.setAttribute("Result_Message", "删除文章异常！");
			request.setAttribute("Result_TYPE", 10);
			request.getRequestDispatcher("/ErrorTip.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
