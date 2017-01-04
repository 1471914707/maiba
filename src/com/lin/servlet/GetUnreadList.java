package com.lin.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lin.util.Tab;

import cn.maiba.Article;
import cn.maiba.Comment;
import cn.maiba.MyDataBase;
import cn.maiba.User;

/**
 * Servlet implementation class GetUnreadList
 */
public class GetUnreadList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetUnreadList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int userId = ((User)request.getSession().getAttribute("user")).getId();
		//SELECT * FROM comments WHERE isread=0 and articleId in(SELECT id FROM articles WHERE userId=6)
		
		Tab tab = new Tab();
		int index = 1;
		String indexString = request.getParameter("index");
		if (indexString != null)
			index = Integer.parseInt(indexString);
		tab.setIndex(index);
		List unreadList = MyDataBase.select(Comment.class, "articleId in(SELECT id FROM articles WHERE userId="+userId+") ORDER BY isread");
		tab.setTotalCount(unreadList.size());
		tab.setPageCount(tab.getTotalCount()%Tab.getSimplenum()==0?tab.getTotalCount()/Tab.getSimplenum():tab.getTotalCount()/Tab.getSimplenum()+1);
		int minIndex = (index-1) * Tab.getSimplenum();
		int maxIndex = tab.getTotalCount() - (index-1) * Tab.getSimplenum() >= Tab.getSimplenum()?Tab.getSimplenum() * index:tab.getTotalCount();
		Comment[] myunreadList = new Comment[maxIndex-minIndex];
		int j=0;
		StringBuffer sb = new StringBuffer();
		for(int i=minIndex; i<maxIndex; i++){
			myunreadList[j] = (Comment) unreadList.get(i);
			sb.append(((User)MyDataBase.load(User.class, ((Comment)unreadList.get(i)).getUserId())).getUserName()+"&"); //获取评论人name
			j++;
		}
		int begin = index-Tab.getColnum()/2>=0?index-Tab.getColnum()/2:1;
		int end = index+Tab.getColnum()/2>tab.getPageCount()?tab.getPageCount():index+Tab.getColnum()/2;
		tab.setBegin(begin);
		tab.setEnd(end);

		request.setAttribute("sbs",sb);
		request.setAttribute("Tab", tab);

		request.setAttribute("myunreadList", myunreadList);		
		request.getRequestDispatcher("/login/MyUnreadList.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
