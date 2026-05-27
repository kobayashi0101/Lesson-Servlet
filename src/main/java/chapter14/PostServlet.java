package chapter14;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Timestamp;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/postServlet")
public class PostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// DB接続パラメータ（index.jsp同様に変更してください）
	private static final String DB_URL = "jdbc:mysql://localhost:3306/bbs_db";
	private static final String DB_USER = "root";
	private static final String DB_PASSWORD = "maiwata";

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 文字化け対策
		request.setCharacterEncoding("UTF-8");

		// フォームから値を取得
		String name = request.getParameter("name");
		String content = request.getParameter("content");

		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
			String sql = "INSERT INTO posts (name, content, post_date) VALUES (?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, content);
			pstmt.setTimestamp(3, new Timestamp(System.currentTimeMillis()));
			pstmt.executeUpdate();
		} catch (Exception e) {
			throw new ServletException(e);
		} finally {
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (Exception e) {
				}
			if (conn != null)
				try {
					conn.close();
				} catch (Exception e) {
				}
		}
		// 登録後、トップページ（index.jsp）へリダイレクト
		response.sendRedirect(request.getContextPath() + "/jsp/index.jsp");
	}

}
