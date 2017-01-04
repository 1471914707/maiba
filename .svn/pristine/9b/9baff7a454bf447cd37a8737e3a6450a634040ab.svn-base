package com.lin.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.maiba.Article;
import cn.maiba.MyDataBase;
import cn.maiba.User;

import com.lin.util.Tab;

/**
 * Servlet implementation class HandleTab
 */
public class HandleTab extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HandleTab() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Tab tab = new Tab();
		int index = 1;
		String indexString = request.getParameter("index");
		if (indexString != null)
			index = Integer.parseInt(indexString);
		tab.setIndex(index);
		List userList1 = MyDataBase.list(User.class);
		tab.setTotalCount(userList1.size());
		tab.setPageCount(tab.getTotalCount()%Tab.getSimplenum()==0?tab.getTotalCount()/Tab.getSimplenum():tab.getTotalCount()/Tab.getSimplenum()+1);
		int minIndex = (index-1) * Tab.getSimplenum();
		int maxIndex = tab.getTotalCount() - (index-1) * Tab.getSimplenum() >= Tab.getSimplenum()?Tab.getSimplenum() * index:tab.getTotalCount();
		User[] userList = new User[maxIndex-minIndex];
		int j=0;
		for(int i=minIndex; i<maxIndex; i++){
			userList[j] = (User) userList1.get(i);
			j++;
		}
		int begin = index-Tab.getColnum()/2>=0?index-Tab.getColnum()/2:1;
		int end = index+Tab.getColnum()/2>tab.getPageCount()?tab.getPageCount():index+Tab.getColnum()/2;
		tab.setBegin(begin);
		tab.setEnd(end);

		request.setAttribute("userList", userList);
		request.setAttribute("Tab", tab);
		request.getRequestDispatcher("/login/UserList.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Tab tab = new Tab();
		int index = 1;
		String indexString = request.getParameter("index");
		if (indexString != null)
			index = Integer.parseInt(indexString);
		tab.setIndex(index);
		List userList1 = MyDataBase.list(User.class);
		tab.setTotalCount(userList1.size());
		tab.setPageCount(tab.getTotalCount()%Tab.getSimplenum()==0?tab.getTotalCount()/Tab.getSimplenum():tab.getTotalCount()/Tab.getSimplenum()+1);
		int minIndex = (index-1) * Tab.getSimplenum();
		int maxIndex = tab.getTotalCount() - (index-1) * Tab.getSimplenum() >= Tab.getSimplenum()?Tab.getSimplenum() * index:tab.getTotalCount();
		User[] userList = new User[maxIndex-minIndex];
		int j=0;
		for(int i=minIndex; i<maxIndex; i++){
			userList[j] = (User) userList1.get(i);
			j++;
		}
		int begin = index-Tab.getColnum()/2>=0?index-Tab.getColnum()/2:1;
		int end = index+Tab.getColnum()/2>tab.getPageCount()?tab.getPageCount():index+Tab.getColnum()/2;
		tab.setBegin(begin);
		tab.setEnd(end);

		request.setAttribute("userList", userList);
		request.setAttribute("Tab", tab);
		request.getRequestDispatcher("/login/UserList.jsp").forward(request, response);
	}

}
