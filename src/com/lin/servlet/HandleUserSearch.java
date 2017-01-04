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
 * Servlet implementation class HandleUserSearch
 */
public class HandleUserSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HandleUserSearch() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String searchContent = request.getParameter("searchContent");
		request.setAttribute("sc",searchContent);
		String select = request.getParameter("select");
		if (searchContent == null || select == null){
			searchContent =(String)request.getSession().getAttribute("searchContent");
			select = (String)request.getSession().getAttribute("select");
		}else{
			request.getSession().setAttribute("searchContent",searchContent);
			request.getSession().setAttribute("select",select);
		}
		Tab tab = new Tab();
		int index = 1;
		String indexString = request.getParameter("index");
		if (indexString != null)
			index = Integer.parseInt(indexString);
		tab.setIndex(index);

		List list1 = null;
		if("user".equals(select)){
			list1 = MyDataBase.select(User.class, "userName like '%"+searchContent+"%'");
			tab.setTotalCount(list1.size());
			tab.setPageCount(tab.getTotalCount()%Tab.getSimplenum()==0?tab.getTotalCount()/Tab.getSimplenum():tab.getTotalCount()/Tab.getSimplenum()+1);
			int minIndex = (index-1) * Tab.getSimplenum();
			int maxIndex = tab.getTotalCount() - (index-1) * Tab.getSimplenum() >= Tab.getSimplenum()?Tab.getSimplenum() * index:tab.getTotalCount();
			User[] list = new User[maxIndex-minIndex];
			int j=0;
			for(int i=minIndex; i<maxIndex; i++){
				list[j] = (User) list1.get(i);
				j++;
			}
			request.setAttribute("resultList", list);
			request.setAttribute("type", 1);
		}else{
			list1 = MyDataBase.select(Article.class, "content like '%"+searchContent+"%' and readpower!=2");
			tab.setTotalCount(list1.size());
			tab.setPageCount(tab.getTotalCount()%Tab.getSimplenum()==0?tab.getTotalCount()/Tab.getSimplenum():tab.getTotalCount()/Tab.getSimplenum()+1);
			int minIndex = (index-1) * Tab.getSimplenum();
			int maxIndex = tab.getTotalCount() - (index-1) * Tab.getSimplenum() >= Tab.getSimplenum()?Tab.getSimplenum() * index:tab.getTotalCount();
			Article[] list = new Article[maxIndex-minIndex];
			int j=0;
			for(int i=minIndex; i<maxIndex; i++){
				list[j] = (Article) list1.get(i);
				j++;
			}
			request.setAttribute("type", 2);
			request.setAttribute("resultList", list);
		}
		int begin = index-Tab.getColnum()/2>=0?index-Tab.getColnum()/2:1;
		int end = index+Tab.getColnum()/2>tab.getPageCount()?tab.getPageCount():index+Tab.getColnum()/2;
		tab.setBegin(begin);
		tab.setEnd(end);
		request.setAttribute("Tab", tab);
		request.getRequestDispatcher("/result-user.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String searchContent = request.getParameter("searchContent");
		String select = request.getParameter("select");
		request.setAttribute("sc",searchContent);
		if (searchContent == null || select == null){
			searchContent =(String)request.getSession().getAttribute("searchContent");
			select = (String)request.getSession().getAttribute("select");
		}else{
			request.getSession().setAttribute("searchContent",searchContent);
			request.getSession().setAttribute("select",select);
		}
		Tab tab = new Tab();
		int index = 1;
		String indexString = request.getParameter("index");
		if (indexString != null)
			index = Integer.parseInt(indexString);
		tab.setIndex(index);

		List list1 = null;
		if("user".equals(select)){
			list1 = MyDataBase.select(User.class, "userName like '%"+searchContent+"%'");
			tab.setTotalCount(list1.size());
			tab.setPageCount(tab.getTotalCount()%Tab.getSimplenum()==0?tab.getTotalCount()/Tab.getSimplenum():tab.getTotalCount()/Tab.getSimplenum()+1);
			int minIndex = (index-1) * Tab.getSimplenum();
			int maxIndex = tab.getTotalCount() - (index-1) * Tab.getSimplenum() >= Tab.getSimplenum()?Tab.getSimplenum() * index:tab.getTotalCount();
			User[] list = new User[maxIndex-minIndex];
			int j=0;
			for(int i=minIndex; i<maxIndex; i++){
				list[j] = (User) list1.get(i);
				j++;
			}
			request.setAttribute("resultList", list);
			request.setAttribute("type", 1);
		}else if("content".equals(select)){
			list1 = MyDataBase.select(Article.class, "content like '%"+searchContent+"%' and readpower!=2");
			tab.setTotalCount(list1.size());
			tab.setPageCount(tab.getTotalCount()%Tab.getSimplenum()==0?tab.getTotalCount()/Tab.getSimplenum():tab.getTotalCount()/Tab.getSimplenum()+1);
			int minIndex = (index-1) * Tab.getSimplenum();
			int maxIndex = tab.getTotalCount() - (index-1) * Tab.getSimplenum() >= Tab.getSimplenum()?Tab.getSimplenum() * index:tab.getTotalCount();
			Article[] list = new Article[maxIndex-minIndex];
			int j=0;
			for(int i=minIndex; i<maxIndex; i++){
				list[j] = (Article) list1.get(i);
				j++;
			}
			request.setAttribute("type", 2);
			request.setAttribute("resultList", list);
		}else{
			list1 = MyDataBase.select(Article.class, "title like '%"+searchContent+"%' and readpower!=2");
			tab.setTotalCount(list1.size());
			tab.setPageCount(tab.getTotalCount()%Tab.getSimplenum()==0?tab.getTotalCount()/Tab.getSimplenum():tab.getTotalCount()/Tab.getSimplenum()+1);
			int minIndex = (index-1) * Tab.getSimplenum();
			int maxIndex = tab.getTotalCount() - (index-1) * Tab.getSimplenum() >= Tab.getSimplenum()?Tab.getSimplenum() * index:tab.getTotalCount();
			Article[] list = new Article[maxIndex-minIndex];
			int j=0;
			for(int i=minIndex; i<maxIndex; i++){
				list[j] = (Article) list1.get(i);
				j++;
			}
			request.setAttribute("type", 3);
			request.setAttribute("resultList", list);
		}
		int begin = index-Tab.getColnum()/2>=0?index-Tab.getColnum()/2:1;
		int end = index+Tab.getColnum()/2>tab.getPageCount()?tab.getPageCount():index+Tab.getColnum()/2;
		tab.setBegin(begin);
		tab.setEnd(end);
		request.setAttribute("Tab", tab);
		request.getRequestDispatcher("/result-user.jsp").forward(request, response);
	}

}
