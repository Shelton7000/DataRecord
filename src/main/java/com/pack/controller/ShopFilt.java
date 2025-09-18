package com.pack.controller;
/*
import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
*/

import java.io.IOException;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class ShopFilt /*extends HttpFilter*/  implements Filter
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ServletContext context;
	static boolean start=false;
	static boolean open=true;
	@Override
	public void init(FilterConfig filterConfig) throws ServletException 
	{
		// TODO Auto-generated method stub
		this.context = filterConfig.getServletContext();
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException 
	{
		// TODO Auto-generated method stub
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		res.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
		res.setHeader("Pragma", "no-cache"); // HTTP 1.0.
		res.setDateHeader("Expires", 0);
		//res.setHeader("cacheSeconds", "0");
		String uri=req.getRequestURI();
		 HttpSession sess = req.getSession(false);
		System.out.println("filterr "+uri+" "+sess);
		if(!start)
		  {  //start=true;
		    System.out.println("ssstt "+uri.toString());
		    start=true;
		    request.setAttribute("login", "false");
	  
		  }
		else
		{ 
		
			
			
			
			
			if(sess==null&& (uri.contains("home")  ||uri.contains("viewInfo")   )      )
		  {
			System.out.println("st");
			 open=true;
			res.sendRedirect("/Records2/start");
			
		  }
		/*else
		{
			lock=false;
		}
		*/
		
		 System.out.println("ex");
			
		}
		
		
		/*
		else
		{
			if(sess==null&&(uri.endsWith("wel.html")||uri.contains("item")||uri.contains("prod")||uri.contains("link")))
			  {   System.out.println("back");
			    //if(!uri.contains("check"))
				// res.sendRedirect("/TestShop/start");
			    //else
			    ///start=true;
			    	// res.sendRedirect("display.html");
			    res.sendRedirect("/TestShop/start");
			  }
			else
				{ if(sess!=null&&sess.getAttribute("person")==null)
					{System.out.println("sthru "+sess+" "+sess.getAttribute("person"));
					 start=false;
					res.sendRedirect("/TestShop/");
					}
				
				
				}
			
			 
		}*/
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() 
	{
		// TODO Auto-generated method stub
		
	}

}
