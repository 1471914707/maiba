package com.lin.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lin.util.Tab;

import cn.maiba.Article;
import cn.maiba.MyDataBase;
import cn.maiba.User;
import cn.maiba.UserType;

/**
 * Servlet implementation class GoModelManage
 */
public class GoModelManage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GoModelManage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		User user = (User)request.getSession().getAttribute("user");
		String modelname = ((UserType)MyDataBase.load(UserType.class, user.getType())).getName();
		request.setAttribute("ModelName", modelname);
		int typeid = user.getType() - 3;
		List articleList = null;
		if (typeid>0){
			articleList = MyDataBase.select(Article.class, "type="+typeid+" and readpower != 2");
			Tab tab = new Tab();
			int index = 1;
			String indexString = request.getParameter("index");
			if (indexString != null)
				index = Integer.parseInt(indexString);
			tab.setIndex(index);
			tab.setTotalCount(articleList.size());
			tab.setPageCount(tab.getTotalCount()%Tab.getSimplenum()==0?tab.getTotalCount()/Tab.getSimplenum():tab.getTotalCount()/Tab.getSimplenum()+1);
			int minIndex = (index-1) * Tab.getSimplenum();
			int maxIndex = tab.getTotalCount() - (index-1) * Tab.getSimplenum() >= Tab.getSimplenum()?Tab.getSimplenum() * index:tab.getTotalCount();
			Article[] articleList1= new Article[maxIndex-minIndex];
			int j=0;
			for(int i=minIndex; i<maxIndex; i++){
				articleList1[j] = (Article) articleList.get(i);
				j++;
			}
			int begin = index-Tab.getColnum()/2>=0?index-Tab.getColnum()/2:1;
			int end = index+Tab.getColnum()/2>tab.getPageCount()?tab.getPageCount():index+Tab.getColnum()/2;
			tab.setBegin(begin);
			tab.setEnd(end);
			request.setAttribute("Tab", tab);
			request.setAttribute("articleList", articleList1);
		}

		request.getRequestDispatcher("/login/ModelManage.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
