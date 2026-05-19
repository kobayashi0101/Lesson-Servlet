package chapter9;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns={"/chapter9/validate"})
public class Validate extends HttpServlet {

	public void doPost(
			HttpServletRequest request,
			HttpServletResponse response
	) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		String username=
				request.getParameter("username");

		if(username==null || username.isEmpty()) {

			request.getRequestDispatcher(
					"error.jsp")
			.forward(request,response);

		}else if(username.equals("admin")) {

			response.sendRedirect(
					request.getContextPath()
					+"/chapter9/admin.jsp");

		}else {

			request.setAttribute(
					"name",username);

			request.getRequestDispatcher(
					"home.jsp")
			.forward(request,response);

		}
	}
}