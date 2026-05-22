package chapter15;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import bean.Product;
import dao.ProductDAO;
import tool.Page;

@WebServlet(urlPatterns={"/chapter15/Practice01"})
public class Practice01 extends HttpServlet {

    public void doGet(
        HttpServletRequest request,
        HttpServletResponse response
    ) throws ServletException, IOException {

        PrintWriter out=response.getWriter();

        Page.header(out);

        try {
            String order=request.getParameter("order");

            ProductDAO dao=new ProductDAO();

            List<Product> list=dao.sort(order);

            for (Product p : list) {
                out.println(p.getId());
                out.println(":");
                out.println(p.getName());
                out.println(":");
                out.println(p.getPrice());
                out.println("<br>");
            }

        } catch (Exception e) {
            e.printStackTrace(out);
        }

        Page.footer(out);
    }
}
