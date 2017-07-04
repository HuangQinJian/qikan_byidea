<%
    String author = (String) session.getAttribute("expertor");
    if (author == null || !author.trim().equals("expertor")) {
        response.sendRedirect("ExpertorLogin.jsp");
        return;
    }
%>