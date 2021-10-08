package servlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.DButil;


@WebServlet("/MainServlet")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private DButil util = DButil.getInstance();
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. data get
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8"); // post일때만 get일때 지정하면 글자 깨짐.
		String isbn  = request.getParameter("isbn");
		String name = request.getParameter("name");
		String author = request.getParameter("author");
		String price = request.getParameter("price");
		String comment = request.getParameter("comment");
		
		// 2. logic
		Connection conn = null;
		PreparedStatement pstmt = null;
		int cnt = 0;
		try {
			conn = util.getConnection();
			String sql = "insert into content(isbn, name, author, price, comment)";
			sql += "values(?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, isbn);
			pstmt.setString(2, name);
			pstmt.setString(3, author);
			pstmt.setString(4, price);
			pstmt.setString(5, comment);
			cnt = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			util.close(pstmt, conn);
		}
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("    <meta charset=\"UTF-8\">");
		out.println("    <title>도서 목록</title>");
		out.println("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">");
		out.println("    <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css\">");
		out.println("    <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js\"></script>");
		out.println("</head>");
		out.println("<body>");
		out.println("    <div class=\"container text-center mt-3\">");
		out.println("        <div class=\"col-lg-8 mx-auto\">");
		if(cnt != 0) {  
			      // logic
			      ResultSet rs = null;
			      try {
			         conn = util.getConnection();
			         String sql = "select *";
			         sql += "from content \n";
			         pstmt = conn.prepareStatement(sql);
			         
			         rs = pstmt.executeQuery();
			         
			         while(rs.next()) {
			            out.println( "<table class=\"table table-active text-left\">");
			            out.println("   <tbody>");
			            out.println("      <tr class=\"table-info\">");
			            out.println("         <td>책번호 : " + rs.getString("isbn") + "</td>");
			            out.println("         <td>책이름 : " + rs.getString("name") + "</td>");
			            out.println("         <td>저자 : " + rs.getString("author") + "</td>");
			            out.println("         <td>가격: " + rs.getString("price") + "</td>");
			            out.println("         <td>설명: " + rs.getString("comment") + "</td>");
			            out.println("         <td class=\"text-right\">책이름 : "+rs.getString("name")+"</td>");
			            out.println("      </tr>");
			            out.println("   </tbody>");
			            out.println("</table>");
			         }
			         
			         out.println("        </div>");
			         out.println("    </div>");
			         out.println("</body>");
			         out.println("</html>");
			         
			      } catch (SQLException e) {
			         e.printStackTrace();
			      } finally {
			         util.close(conn, pstmt, rs);
			      }   
		}
		else {
			out.println("");
			out.println("            <div class=\"jumbotron\">");
			out.println("                <h1 class=\"text-danger\">도서추가 실패 T.T</h1>");
			out.println("            </div>");
			
		}
		out.println("        </div>");
		out.println("    </div>");
		out.println("</body>");
		out.println("</html>");
	}

}
