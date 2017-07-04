package com.hqj.servlet;

import com.hqj.model.Editor;
import com.hqj.serviceimpl.EditorServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class EditorRegiest
 */
public class EditorRegiest extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditorRegiest() {
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
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        Editor editor = new Editor();
        editor.setEditname(name);
        editor.setEditpass(password);
        if (name != null && password != null) {
            if (new EditorServiceImpl().getInstance().add(editor)) {
                response.sendRedirect("EditorLogin.jsp");
            } else
                response.sendRedirect("/qikan/editorjsp/EditorRegiest.jsp");
        }
    }
}
