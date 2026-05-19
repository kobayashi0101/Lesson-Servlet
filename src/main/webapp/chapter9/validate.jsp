<%@ page contentType="text/html; charset=UTF-8" %>
<%
    String username = request.getParameter("username");

    if (username == null || username.trim().isEmpty()) {
        // ユーザー名が空 → error.jsp に forward
        RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
        rd.forward(request, response);
    } else if ("admin".equals(username)) {
        // admin → admin.jsp にリダイレクト（URLが変わる）
        response.sendRedirect("admin.jsp");
    } else {
        // 一般ユーザー → home.jsp に forward（URLそのまま）
        RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
        rd.forward(request, response);
    }
%>