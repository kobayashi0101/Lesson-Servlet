<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

 
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
 
    <title>ようこそ</title>
 
</head>
 
<body>
 
    LOGIN FORM
 
    <form method="post" action="LoginServlet">
 
        <div class="inputLow">
            <p>
                <input type="text"
                       id="name"
                       name="username"
                       placeholder="username"/>
            </p>
        </div>
 
        <div class="inputLow">
            <p>
                <input type="password"
                       id="password"
                       name="password"
                       placeholder="password"/>
            </p>
        </div>
 
        <input type="submit"
               id="Login"
               value="Login"/>
 
    </form>
 
</body>
</html>