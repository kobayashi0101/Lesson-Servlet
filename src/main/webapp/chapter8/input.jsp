<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="../header.html" %>

<form action="output.jsp" method="post">

ユーザー名：
<input type="text" name="username">

<br><br>

年齢：
<input type="text" name="age">

<br><br>

<input type="submit" value="送信">

</form>

<%@include file="../footer.html" %>