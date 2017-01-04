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
import cn.maiba.Notices;
import cn.maiba.User;

import com.lin.util.Tab;

/**
 * Servlet implementation class GetModelDetail
 */
public class GetModelDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetModelDetail() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("typeId"));
		String name =((Articletype)MyDataBase.load(Articletype.class, id)).getName();
		Tab tab = new Tab();
		int index = 1;
		String indexString = request.getParameter("index");
		if (indexString != null)
			index = Integer.parseInt(indexString);
		tab.setIndex(index);
		List articleList1= MyDataBase.select(Article.class,"type="+id+" and readpower!=2  ORDER BY stick desc,lastTime DESC");
		tab.setTotalCount(articleList1.size());
		tab.setPageCount(tab.getTotalCount()%Tab.getSimplenum()==0?tab.getTotalCount()/Tab.getSimplenum():tab.getTotalCount()/Tab.getSimplenum()+1);
		int minIndex = (index-1) * Tab.getSimplenum();
		int maxIndex = tab.getTotalCount() - (index-1) * Tab.getSimplenum() >= Tab.getSimplenum()?Tab.getSimplenum() * index:tab.getTotalCount();
		Article[] articleList = new Article[maxIndex-minIndex];
		int j=0;
		StringBuffer sb = new StringBuffer();
		for(int i=minIndex; i<maxIndex; i++){
			articleList[j] = (Article) articleList1.get(i);
			sb.append(((User)MyDataBase.load(User.class, ((Article)articleList1.get(i)).getUserId())).getUserName()+"&");
			j++;
		}
		int begin = index-Tab.getColnum()/2>=0?index-Tab.getColnum()/2:1;
		int end = index+Tab.getColnum()/2>tab.getPageCount()?tab.getPageCount():index+Tab.getColnum()/2;
		tab.setBegin(begin);
		tab.setEnd(end);
	
		//找版主发布的公告
		List myList = MyDataBase.select(Notices.class, "now()<endtime");
		//筛选
		for(int i=0; i<myList.size(); i++){
			Notices notice = (Notices)myList.get(i);
			User user = (User) MyDataBase.load(User.class,notice.getUserId());
			if (! ((user.getType()-id)==3)){
				myList.remove(i);
			}
		}
		request.setAttribute("myList", myList);
		request.setAttribute("articleList", articleList);
		request.setAttribute("sbs",sb);
		request.setAttribute("modelName",name);
		request.setAttribute("Tab", tab);
		request.setAttribute("typeId", id);
		request.getRequestDispatcher("/article-model.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("typeId"));
		String name =((Articletype)MyDataBase.load(Articletype.class, id)).getName();
		Tab tab = new Tab();
		int index = 1;
		String indexString = request.getParameter("index");
		if (indexString != null)
			index = Integer.parseInt(indexString);
		tab.setIndex(index);
		List articleList1= MyDataBase.select(Article.class,"type="+id+" and readpower!=2");
		tab.setTotalCount(articleList1.size());
		tab.setPageCount(tab.getTotalCount()%Tab.getSimplenum()==0?tab.getTotalCount()/Tab.getSimplenum():tab.getTotalCount()/Tab.getSimplenum()+1);
		int minIndex = (index-1) * Tab.getSimplenum();
		int maxIndex = tab.getTotalCount() - (index-1) * Tab.getSimplenum() >= Tab.getSimplenum()?Tab.getSimplenum() * index:tab.getTotalCount();
		Article[] articleList = new Article[maxIndex-minIndex];
		int j=0;
		StringBuffer sb = new StringBuffer();
		for(int i=minIndex; i<maxIndex; i++){
			articleList[j] = (Article) articleList1.get(i);
			sb.append(((User)MyDataBase.load(User.class, ((Article)articleList1.get(i)).getUserId())).getUserName()+"&");
			j++;
		}
		int begin = index-Tab.getColnum()/2>=0?index-Tab.getColnum()/2:1;
		int end = index+Tab.getColnum()/2>tab.getPageCount()?tab.getPageCount():index+Tab.getColnum()/2;
		tab.setBegin(begin);
		tab.setEnd(end);

		//找版主发布的公告
		List myList = MyDataBase.select(Notices.class, "now()<endtime limit 1");
		//筛选
		for(int i=0; i<myList.size(); i++){
			Notices notice = (Notices)myList.get(i);
			User user = (User) MyDataBase.load(User.class,notice.getUserId());
			if (! ((user.getType()-id)==3)){
				myList.remove(i);
			}
		}
		request.setAttribute("myList", myList);
		request.setAttribute("articleList", articleList);
		request.setAttribute("sbs",sb);
		request.setAttribute("modelName",name);
		request.setAttribute("Tab", tab);
		request.setAttribute("typeId", id);
		request.getRequestDispatcher("/article-model.jsp").forward(request, response);
	}

}
