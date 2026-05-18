<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="../header.html" %>

<%@page errorPage="error.jsp" %>

<%
request.setCharacterEncoding("UTF-8");

String username = request.getParameter("username");
String ageText = request.getParameter("age");

if(username == null || username.isEmpty() || ageText == null || ageText.isEmpty()){
    throw new Exception("ユーザー名または年齢が正しくありません。");
}

int age = Integer.parseInt(ageText);
%>

<p>ユーザー名：<%=username %></p>
<p>年齢：<%=age %></p>

<%@include file="../footer.html" %>