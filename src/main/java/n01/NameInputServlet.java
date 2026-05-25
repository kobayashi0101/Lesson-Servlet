package n01;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet(urlPatterns={"/n01/input"})
public class NameInputServlet extends HttpServlet{

    public void doPost(
            HttpServletRequest request,
            HttpServletResponse response)
    throws ServletException,IOException{

        request.setCharacterEncoding("UTF-8");

        String name=request.getParameter("name");

        HttpSession session=request.getSession();

        session.setAttribute("name",name);

        response.sendRedirect("output.jsp");
    }
}

