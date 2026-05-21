package chapter14;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import tool.Page;

@WebServlet(urlPatterns={"/chapter14/practice02"})
public class Practice02 extends HttpServlet {

    public void doPost(
        HttpServletRequest request,
        HttpServletResponse response
    ) throws ServletException, IOException {

        response.setContentType("text/html; charset=UTF-8");
        request.setCharacterEncoding("UTF-8");

        PrintWriter out = response.getWriter();
        Page.header(out);

        try {
            InitialContext ic = new InitialContext();

            DataSource ds =
                (DataSource)ic.lookup("java:/comp/env/jdbc/book");

            Connection con = ds.getConnection();

            int count =
                Integer.parseInt(request.getParameter("count"));

            String payment =
                request.getParameter("payment");

            String review =
                request.getParameter("review");

            boolean mail =
                request.getParameter("mail") != null;

            String name =
                review + " / 支払方法:" + payment + " / メール:" + mail;

            PreparedStatement st =
                con.prepareStatement(
                    "insert into product(name,price) values(?,?)"
                );

            st.setString(1, name);
            st.setInt(2, count);

            int line = st.executeUpdate();

            if (line > 0) {
                out.println("<p>productテーブルに登録しました。</p>");
            }

            out.println("<p>" + count + "個の商品をカートに入れました。</p>");
            out.println("<p>お支払い方法を" + payment + "に設定しました。</p>");
            out.println("<p>「" + review + "」</p>");

            if (mail) {
                out.println("<p>メールをお送りします。</p>");
            } else {
                out.println("<p>メールはお送りしません。</p>");
            }

            st.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace(out);
        }

        Page.footer(out);
    }
}