<%@ page contentType="text/html; charset=UTF-8" %>

<%@ page import="java.util.Date" %>

<%@ include file="../header.html" %>

<%
    Date today = new Date();
%>

<p>現在の日付：</p>

<p>
    <%= today %>
</p>

<%@ include file="../footer.html" %>