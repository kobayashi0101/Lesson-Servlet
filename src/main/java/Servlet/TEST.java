package Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import tool.Page;

@WebServlet(urlPatterns={"/chapter6/checkbox"})
public class  TEST extends HttpServlet {

    public void doPost (
        HttpServletRequest request,
        HttpServletResponse response
    ) throws ServletException, IOException {

        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out=response.getWriter();

        request.setCharacterEncoding("UTF-8");
        String count=request.getParameter("count");
        String payment=request.getParameter("payment");
        String payment=request.getParameter("payment");
        String payment=request.getParameter("payment");
        String payment=request.getParameter("payment");
        String value=request.getParameter("valuet");

        Page.footer(out);
    }
}