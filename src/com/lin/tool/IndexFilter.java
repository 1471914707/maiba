package com.lin.tool;

import java.io.IOException;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.maiba.Article;
import cn.maiba.Articletype;
import cn.maiba.Comment;
import cn.maiba.MyDataBase;
import cn.maiba.Notices;
import cn.maiba.User;

/**
 * Servlet Filter implementation class IndexFilter
 */
public class IndexFilter implements Filter {
	private static final String INDEX_URL1 = "/maiba/";
	private static final String INDEX_URL2 = "index.jsp";
    /**
     * Default constructor. 
     */
    public IndexFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		HttpServletRequest httpRequest = (HttpServletRequest)request;		
		if (isIndexUrl(httpRequest.getRequestURI())){
			List typelist =  MyDataBase.list(Articletype.class);
			int num = typelist.size();
			List[] lists = new List[num];
			for (int i=0; i<num; i++){
				lists[i] = MyDataBase.select(Article.class, "type="+((Articletype)typelist.get(i)).getId()+" and readpower != 2 order by stick desc,lastTime desc LIMIT 10");
			}
			//String 
			List superUserList = MyDataBase.select(User.class, "id ORDER BY `value` DESC LIMIT 8");
			List todayNewList = MyDataBase.select(Article.class, "substring(lastTime, 1, 10)= CURDATE() ORDER BY lastTime DESC LIMIT 8");
			request.setAttribute("todayNewList", todayNewList);
			request.setAttribute("superUserList", superUserList);
			request.setAttribute("typelist", typelist);
			request.setAttribute("lists", lists);
			request.setAttribute("OnlineCounters", OnlineCounter.getCounter());
			
			int ArticlesCount = MyDataBase.Count(Article.class);
			request.setAttribute("ArticlesCount", ArticlesCount);
			
			int CommentCount = MyDataBase.Count(Comment.class);
			request.setAttribute("CommentCount", CommentCount);
			
			int UserCount = MyDataBase.Count(User.class);
			request.setAttribute("UserCount", UserCount);
			
			//找公告，主页显示的是超级管理员的公告
			List noticeList = MyDataBase.select(Notices.class, "now()<endtime");
			//筛选
			for (int i=0; i< noticeList.size(); i++){
				Notices notice =(Notices) noticeList.get(i);
				User user = (User) MyDataBase.load(User.class, notice.getUserId());
				if (1!=user.getType()){
					noticeList.remove(i);
				}
			}
			request.setAttribute("myList", noticeList);
						
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		}
		// pass the request along the filter chain
	//	chain.doFilter(request, response);
	}

	private boolean isIndexUrl(String requestURI) {
		// TODO Auto-generated method stub
		return requestURI.substring(requestURI.length()-7).equals(INDEX_URL1) || requestURI.contains(INDEX_URL2);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
