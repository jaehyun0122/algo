package com.ssafy.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBClose {

//	public static void close(Connection conn, PreparedStatement pstmt) {
//		try {
//			if(pstmt != null) {
//				pstmt.close();
//			}
//			if(conn != null)
//				conn.close();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//	
//	public static void close(Connection conn, PreparedStatement pstmt, ResultSet rs) {
//		try {
//			if(pstmt != null) {
//				pstmt.close();
//			}
//			if(conn != null)
//				conn.close();
//			if(rs != null) rs.close();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
	
//	 위의 2개를 합친 것  ...은 가변인자 
	public static void close(AutoCloseable...autoCloseable) {
		for(AutoCloseable ac : autoCloseable) {
			if(ac != null)
				try {
					ac.close();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}
}
