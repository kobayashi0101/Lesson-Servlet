<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="../header.html" %>

<%@page isErrorPage="true" %>

<p>入力エラー：<%=exception.getMessage() %></p>

<%@include file="../footer.html" %>