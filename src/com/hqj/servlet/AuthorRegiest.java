package com.hqj.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hqj.model.Author;
import com.hqj.serviceimpl.AuthorServiceImpl;

/**
 * Servlet implementation class AuthorRegiest
 */
public class AuthorRegiest extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AuthorRegiest() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		Author author = new Author();
		author.setAutoname(name);
		author.setAutopass(password);
		if (name != null && password != null) {
			if (new AuthorServiceImpl().getInstance().add(author)) {
				response.sendRedirect("AuthorLogin.jsp");
			} else
				System.out.println("no");
		}
	}

}
