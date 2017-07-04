
<%
	String author = (String) session.getAttribute("author");
	if (author == null || !author.trim().equals("author")) {
		response.sendRedirect("ueditor/authorjsp/AuthorLogin.jsp");
		return;
	}
%>