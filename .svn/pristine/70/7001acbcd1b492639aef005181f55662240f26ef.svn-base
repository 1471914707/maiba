package com.lin.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.maiba.Article;
import cn.maiba.MyDataBase;
import cn.maiba.Notices;
import cn.maiba.User;

import com.lin.util.Tab;

/**
 * Servlet implementation class HanleNotices
 */
public class HanleNotices extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HanleNotices() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		User user =(User) request.getSession().getAttribute("user");
		Tab tab = new Tab();
		int index = 1;
		String indexString = request.getParameter("index");
		if (indexString != null)
			index = Integer.parseInt(indexString);
		tab.setIndex(index);
		List noticeList1= MyDataBase.select(Notices.class,"userId="+user.getId());
		tab.setTotalCount(noticeList1.size());
		tab.setPageCount(tab.getTotalCount()%Tab.getSimplenum()==0?tab.getTotalCount()/Tab.getSimplenum():tab.getTotalCount()/Tab.getSimplenum()+1);
		int minIndex = (index-1) * Tab.getSimplenum();
		int maxIndex = tab.getTotalCount() - (index-1) * Tab.getSimplenum() >= Tab.getSimplenum()?Tab.getSimplenum() * index:tab.getTotalCount();
		Notices[] noticeList = new Notices[maxIndex-minIndex];
		int j=0;
		for(int i=minIndex; i<maxIndex; i++){
			noticeList[j] = (Notices) noticeList1.get(i);
			j++;
		}
		int begin = index-Tab.getColnum()/2>=0?index-Tab.getColnum()/2:1;
		int end = index+Tab.getColnum()/2>tab.getPageCount()?tab.getPageCount():index+Tab.getColnum()/2;
		tab.setBegin(begin);
		tab.setEnd(end);

		request.setAttribute("noticeList", noticeList);
		request.setAttribute("Tab", tab);
		request.getRequestDispatcher("/login/Noitces.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if (request.getParameter("index") != null){
			doGet(request, response);
		}else{
			Notices notice = new Notices();
			notice.setUserId(((User)request.getSession().getAttribute("user")).getId());
			notice.setTitle(request.getParameter("title"));
			notice.setContent(request.getParameter("content"));
			double time = Double.parseDouble(request.getParameter("time"));
			int t = (int)( time+0.5);
			SimpleDateFormat ds = new SimpleDateFormat("yyyy-MM-dd HH:mm");		
			Date date = new Date();
			notice.setStarttime(ds.format(date));
			Calendar c = Calendar.getInstance();   
			c.add(Calendar.HOUR, t);
			notice.setEndtime(ds.format(c.getTime()));
			if (MyDataBase.save(notice)){
				request.setAttribute("Mess", "发布成功");
			}else{
				request.setAttribute("Mess", "发布失败");
			}
			response.sendRedirect(request.getContextPath()+"/login/HanleNotices");
		//	request.getRequestDispatcher("/login/Noitces.jsp").forward(request, response);		
		}
	}
}
