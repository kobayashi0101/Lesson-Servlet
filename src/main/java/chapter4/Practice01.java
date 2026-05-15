package chapter4;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns={"/chapter4/practice01"})
public class Practice01 extends HttpServlet {

public void doGet(HttpServletRequest request, HttpServletResponse response)
throws ServletException, IOException {

response.setContentType("text/html; charset=UTF-8");
PrintWriter out = response.getWriter();

java.time.format.DateTimeFormatter fmt = java.time.format.DateTimeFormatter.ofPattern("yyyy年MM月dd日(E) HH時mm分ss秒");
String now = java.time.LocalDateTime.now().format(fmt);

out.println("<html><body>");
out.println("<p>現在の時刻は：" + now + "です</p>");
out.println("</body></html>");
}
}
