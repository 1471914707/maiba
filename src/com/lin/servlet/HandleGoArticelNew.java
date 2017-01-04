package com.lin.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.maiba.Article;
import cn.maiba.Articletype;
import cn.maiba.MyDataBase;

/**
 * Servlet implementation class HandleGoArticelNew
 */
public class HandleGoArticelNew extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HandleGoArticelNew() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List list  = (List) MyDataBase.list(Articletype.class);
		Articletype[] articletypes = new Articletype[list.size()];
		for (int i=0; i<list.size(); i++){
			articletypes[i] = (Articletype)list.get(i);
		}
		request.setAttribute("articletypes", articletypes);
		request.getRequestDispatcher("/login/article-new.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
