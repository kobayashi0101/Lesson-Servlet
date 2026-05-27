package servlet;

import java.io.IOException;
import java.util.List;

import dao.EmployeeDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Employee;

@WebServlet("/EmployeeServlet")
public class EmployeeServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			EmployeeDAO dao = new EmployeeDAO();
			List<Employee> list = dao.findAll();
			request.setAttribute("employees", list);
			request.getRequestDispatcher("employeelist.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}