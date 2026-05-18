<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="../header.html" %>

<%@page errorPage="square-error.jsp" %>

<%
request.setCharacterEncoding("UTF-8");

int number =
    Integer.parseInt(
        request.getParameter("number"));

int result = number * number;
%>

入力した数値：<%=number %>

<br><br>

結果：<%=result %>

<%@include file="../footer.html" %>