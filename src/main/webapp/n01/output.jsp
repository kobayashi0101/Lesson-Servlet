<%@ page contentType="text/html;charset=UTF-8"
pageEncoding="UTF-8" %>

<%
String name=(String)session.getAttribute("name");
%>

<h2>
こんにちは、<%=name%>さん！
</h2>
<p>
<a href="input.jsp">戻る</a>
</p>