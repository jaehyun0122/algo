import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ssafy.util.DBClose;
import com.ssafy.util.DBConnection;

public class PhoneManager {
	public void insertPhone(Phone phone) {
		Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            //db연결
            conn = DBConnection.getConnection();
        
            //Prepared Statement 방식
            String sql = "insert into phone (p_idx, p_name,p_price) values(?,?,?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, phone.getIdx());
            pstmt.setString(2, phone.getName());
            pstmt.setInt(3, phone.getPrice());
            
            //SQL 실행
            int cnt = pstmt.executeUpdate();
            System.out.println(cnt+"개 삽입 성공");
            
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            DBClose.close(conn, pstmt);
        }
	}
	public Phone selectOne(int idx) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Phone p = null;
        try {
            conn = DBConnection.getConnection();
        
            //Prepared Statement 방식
            String sql = "select p_idx, p_name, p_price from phone where p_idx =?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, idx);
            
            //SQL 실행
            rs = pstmt.executeQuery();
            rs.next();
            p = new Phone(rs.getInt("p_idx"), rs.getString("p_name"), rs.getInt("p_price"));
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            DBClose.close(rs, pstmt, conn);
        }
        return p;
    }
	
	
	
	public List<Phone> selectAll(){
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Phone> list = new ArrayList<Phone>() { };
		
		try {
			conn = DBConnection.getConnection();
			String sql = "select p_idx, p_name, p_price\n";
			// prepared statement : 치환 변수를 사용가능
			sql += "from phone \n";
			pstmt = conn.prepareStatement(sql);
			// setString(para, ) sql의 인덱스는 1부터 시작하므로
			
			rs = pstmt.executeQuery();
			while(rs.next()) { //첫번째 next는 first() 효과, 다음부터 next()역할을 함
                list.add(new Phone(rs.getInt("p_idx"), rs.getString("p_name"), rs.getInt("p_price")));
            }
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(conn, pstmt, rs);
		}
		return list;
	}
	
	
}
