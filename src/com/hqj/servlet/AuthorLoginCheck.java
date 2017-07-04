package com.hqj.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hqj.serviceimpl.AuthorServiceImpl;

/**
 * Servlet implementation class AuthorLoginCheck
 */
public class AuthorLoginCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AuthorLoginCheck() {
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
        String name=request.getParameter("name");
        String password=request.getParameter("password");
        if(name!=null&&password!=null){
               if(new AuthorServiceImpl().getInstance().search(name,password)){
            	  // System.out.println("��½�ɹ�");
            	  // request.getRequestDispatcher("/AuthorHome.jsp").forward(request, response);
            	   request.getSession().setAttribute("author", "author");
            	   request.getSession().setAttribute("name", name);
            	   response.sendRedirect("AuthorHome.jsp");
               }
               else 
            	   System.out.println("no");
        }
	}
}
