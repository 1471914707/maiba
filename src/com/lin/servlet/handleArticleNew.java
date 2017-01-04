package com.lin.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.maiba.Article;
import cn.maiba.MyDataBase;
import cn.maiba.User;

/**
 * Servlet implementation class handleArticleNew
 */
public class handleArticleNew extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public handleArticleNew() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		if ("".equals(title) || content.length()<10){
			request.setAttribute("Result_Message", "标题为空或内容不足十字！请返回");
			request.setAttribute("Result_TYPE", 9);
			request.setAttribute("title", title);
			request.setAttribute("content", content);
			request.getRequestDispatcher("/ErrorTip.jsp").forward(request, response);
		}
		Article article = new Article();
		User user = (User)request.getSession().getAttribute("user");
		article.setUserId(user.getId());
		 //发表文章加2积分
		user.setValue(user.getValue()+2);
		MyDataBase.update(user);
		article.setTitle(title);
		article.setContent(content);
		Date date = new Date();
		SimpleDateFormat ds = new SimpleDateFormat("yyyy-MM-dd HH:mm");		
		article.setLastTime(ds.format(date));
		article.setPageView(0);
		article.setReplyCount(0);
		int articletype = Integer.parseInt(request.getParameter("articletype"));
		article.setType(articletype);
		article.setReadpower(Integer.parseInt(request.getParameter("readpower")));
		article.setCommentpower(Integer.parseInt(request.getParameter("commentpower")));
		MyDataBase.save(article);
		request.setAttribute("Result_Message", "恭喜你，文章发表成功！");
		request.setAttribute("Result_TYPE", 10);
		request.getRequestDispatcher("/ErrorTip.jsp").forward(request, response);
	}
	
}
