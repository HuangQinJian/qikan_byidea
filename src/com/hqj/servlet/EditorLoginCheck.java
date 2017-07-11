package com.hqj.servlet;

import com.hqj.model.Editor;
import com.hqj.serviceimpl.EditorServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class EditorLoginCheck
 */
public class EditorLoginCheck extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditorLoginCheck() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        response.setCharacterEncoding("utf-8");
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        Editor editor = new Editor();
        editor.setEditname(name);
        editor.setEditpass(password);
        if (new EditorServiceImpl().getInstance().search(name, password)) {
            request.getSession().setAttribute("editor", "editor");
            request.getSession().setAttribute("name", name);
            response.sendRedirect("/qikan/editorjsp/EditorHome.jsp");
        } else {
            response.sendRedirect("/qikan/errorpage/EditorLoginErr.jsp");
        }
    }
}
