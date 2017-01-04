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

import com.sun.org.apache.bcel.internal.generic.ARETURN;

/**
 * Servlet implementation class HandleArticleUpdate
 */
public class HandleArticleUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HandleArticleUpdate() {
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
		int id = Integer.parseInt(request.getParameter("id"));
		Article article = (Article) MyDataBase.load(Article.class, id);
		article.setContent(content);
		article.setTitle(title);
		Date date = new Date();
		SimpleDateFormat ds = new SimpleDateFormat("yyyy-MM-dd HH:mm");		
		article.setLastTime(ds.format(date));
		int articletype = Integer.parseInt(request.getParameter("articletype"));
		article.setType(articletype);
		article.setReadpower(Integer.parseInt(request.getParameter("readpower")));
		article.setCommentpower(Integer.parseInt(request.getParameter("commentpower")));
		if (MyDataBase.update(article)){
			request.setAttribute("Mess", "修改成功！");
			request.getRequestDispatcher("/HandleArticleDetail?articleId="+id).forward(request, response);
		}else{
			request.setAttribute("Result_TYPE", 11);
			request.setAttribute("Result_Message", "修改失败！请检查原因：标题为空，内容不足十字，更新异常。");
			request.setAttribute("id", id);
			request.getRequestDispatcher("/ErrorTip.jsp").forward(request, response);
		}
	}

}
