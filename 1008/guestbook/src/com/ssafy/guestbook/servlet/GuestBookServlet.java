package com.ssafy.guestbook.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssafy.guestbook.util.DButil;


@WebServlet("/guestbook")
public class GuestBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private DButil dbutil = DButil.getInstance();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String act = request.getParameter("act");
		if("register".equals(act)) {
			// DB에 넣고
			String userid = request.getParameter("userid");
			String subject = request.getParameter("subject");
			String content = request.getParameter("content");
			Connection conn = null;
			PreparedStatement pstmt = null;
			int cnt = 0;
			String path ="";
			try {
				conn = dbutil.getConnection();
				String sql = "insert into guestbook(userid, subject, content)"
						+ "values(?,?,?)";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, userid);
				pstmt.setString(2, subject);
				pstmt.setString(3, content);
				cnt = pstmt.executeUpdate();
				
			} catch (SQLException e) {					// TODO Auto-generated catch block
				path = "error.jsp";
			} finally {
				dbutil.close(pstmt, conn);
			}
			path = cnt != 0 ? "writesuccess.jsp" : "writefail.jsp";
			request.getRequestDispatcher(path).forward(request, response);
			} 
		
			else if("list".equals(act)) {
				List<GuestBookDto> list = new ArrayList<GuestBookDto>();
				Connection conn = null;
				PreparedStatement pstmt = null;
				ResultSet rs = null;
				try {
					conn = dbutil.getConnection();
					String sql = "select * from guestbook order by articleno desc";
					pstmt = conn.prepareStatement(sql);
					rs = pstmt.executeQuery();
					while(rs.next()) {
						GuestBookDto gb = new GuestBookDto();
						gb.setArticleNo(rs.getInt("articleno"));
						gb.setUserId(rs.getString("userid"));
						gb.setSubject(rs.getString("subject"));
						gb.setContent(rs.getString("content"));
						gb.setRegTime(rs.getString("regtime"));
						list.add(gb);
					}
				} catch (Exception e) {
					System.out.println("error");
				} finally {
					dbutil.close(conn, pstmt, rs);
				}
				request.setAttribute("articles", list);
				request.getRequestDispatcher("list.jsp").forward(request, response);
			}
			else if("modify".equals(act)) {
				String subject = request.getParameter("subject");
				String content = request.getParameter("content");
				String userid = request.getParameter("userid");
				System.out.println(act);
				System.out.println(subject);
				System.out.println(content);
				System.out.println(userid);
				Connection conn = null;
				PreparedStatement pstmt = null;
				int cnt = 0;
				String path = "";
				
				try {
					conn = dbutil.getConnection();
					String sql = "update guestbook set subject = ?, content = ? where userid = ?";
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, subject);
					pstmt.setString(2, content);
					pstmt.setString(3, userid);
					cnt = pstmt.executeUpdate();
				} catch (SQLException e) {
					path = "error.jsp";
				} finally {
					dbutil.close(pstmt, conn);
				}
				path = cnt != 0 ? "writesuccess.jsp" : "writefail.jsp";
				request.getRequestDispatcher(path).forward(request, response);
			}
			else if("remove".equals(act)) {
				String userid = request.getParameter("userid");
				String articleno = request.getParameter("articleno");
				System.out.println(act);
				System.out.println(userid);
				System.out.println(articleno);
				Connection conn = null;
				PreparedStatement pstmt = null;
				int cnt = 0;
				String path ="";
				try {
					conn = dbutil.getConnection();
					String sql = "delete from guestbook where userid=? and articleno=?";
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, userid);
					pstmt.setString(2, articleno);
					cnt = pstmt.executeUpdate();
					
				} catch (SQLException e) {					// TODO Auto-generated catch block
					path = "error.jsp";
				} finally {
					dbutil.close(pstmt, conn);
				}
				path = cnt != 0 ? "writesuccess.jsp" : "writefail.jsp";
				request.getRequestDispatcher(path).forward(request, response);
			}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		doGet(request, response);

	}

}
