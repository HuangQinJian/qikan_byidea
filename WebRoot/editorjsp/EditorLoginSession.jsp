<%
    String author = (String) session.getAttribute("editor");
    if (author == null || !author.trim().equals("editor")) {
        response.sendRedirect("EditorLogin.jsp");
        return;
    }
%>