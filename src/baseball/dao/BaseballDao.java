package baseball.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import baseball.vo.Baseball;
import baseball.db.DBCon;

public class BaseballDao {

	// 메인 리스트
	public List<Baseball> baseSelall(String field, String query) throws Exception {
		// List<Baseball>은 baseball.vo의 baseball.java이다.
		Connection con = DBCon.getConnection();

		String sql = "select * from bbschedule where " + field + " like ? order by bbno desc";

		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, "%" + query + "%");

		ResultSet rs = pstmt.executeQuery();

		List<Baseball> list = new ArrayList<Baseball>();

		while (rs.next()) {
			Baseball b = new Baseball();
			b.setBbno(rs.getInt("bbno"));
			b.setBbtitle(rs.getString("bbtitle"));
			b.setBbcontent(rs.getString("bbcontent"));
			b.setBbdate(rs.getString("bbdate"));
			b.setBbday(rs.getString("bbday"));
			b.setBbplace(rs.getString("bbplace"));
			b.setBbhit(rs.getInt("bbhit"));
			b.setFilesrc(rs.getString("filesrc"));
			list.add(b);
		}
		return list;
	}
	//hit 조회
	public void hitupdate(String bbno,int num) throws Exception{
		System.out.println("hit up>Dao hitupdate");
		Connection con=DBCon.getConnection();
		String sql = "update bbschedule set bbhit=? where bbno=?";
		
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setInt(1, num+1);
		pstmt.setString(2, bbno);
		
		pstmt.executeUpdate();
	}
	public Baseball getBaseball(String bbno,String bbhit) throws Exception {
		
		int hnum=Integer.parseInt(bbhit);
		hitupdate(bbno, hnum);
		
		String sql = "select * from bbschedule where bbno=" + bbno;
		Connection con=DBCon.getConnection();		
		
		// 실행
		Statement st = con.createStatement();
		// 결과
		ResultSet rs = st.executeQuery(sql);

		rs.next();
		
		Baseball b = new Baseball();
		b.setBbno(rs.getInt("bbno"));
		b.setBbtitle(rs.getString("bbtitle"));
		b.setBbcontent(rs.getString("bbcontent"));
		b.setBbdate(rs.getString("bbdate"));
		b.setFilesrc(rs.getString("filesrc"));
		
		rs.close();
		st.close();
		con.close();
				

		return b;

	}
	//삭제 페이지
	public int delete(String bbno) throws Exception{
		String sql="delete from bbschedule where bbno=?";
		
		Connection con=DBCon.getConnection();
		
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, bbno);
		int del=pstmt.executeUpdate();
		
		pstmt.close();
		con.close();
		
		return del;		
	}
	
	public int update(Baseball baseball) throws Exception{
		String sql = "update bbschedule" + " SET bbtitle=?, bbcontent=?, bbdate=?, filesrc=? where bbno=?";
		
		Connection con = DBCon.getConnection();
		
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, baseball.getBbtitle());
		pstmt.setString(2, baseball.getBbcontent());
		pstmt.setString(3, baseball.getBbdate());
		pstmt.setString(4, baseball.getFilesrc());
		pstmt.setInt(5, baseball.getBbno());
		
		int af=pstmt.executeUpdate();
		
		System.out.println("af"+af);
		pstmt.close();
		con.close();
		
		return af;				
	}

	// 상세페이지
	public Baseball getBaseball(int bbno) throws Exception {

		String sql = "select * from bbschedule where bbno=" + bbno;

		Connection con = DBCon.getConnection();
		// 실행
		Statement st = con.createStatement();
		// 결과
		ResultSet rs = st.executeQuery(sql);
		
		rs.next();
		
		Baseball b = new Baseball();
		b.setBbno(rs.getInt("bbno"));
		b.setBbtitle(rs.getString("bbtitle"));
		b.setBbcontent(rs.getString("bbcontent"));
		b.setBbdate(rs.getString("bbdate"));
		b.setBbday(rs.getString("bbday"));
		b.setBbplace(rs.getString("bbplace"));
		b.setBbhit(rs.getInt("bbhit"));
		b.setFilesrc(rs.getString("filesrc"));
		
		rs.close();
		st.close();
		con.close();
				

		return b;
	}
	
	public int write(Baseball bb) throws Exception{
		String sql = "insert into bbschedule values((select nvl(max(bbno)+1,1) from bbschedule)"
				+ ",?,?,?,?,?,0,?)";
		
		Connection con = DBCon.getConnection();
		
		// 실행
		PreparedStatement pstmt = con.prepareStatement(sql);
		int af = 0;
		try {
			pstmt.setString(1, bb.getBbtitle());
			pstmt.setString(2, bb.getBbcontent());
			pstmt.setString(3, bb.getBbdate());
			pstmt.setString(4, bb.getBbday());
			pstmt.setString(5, bb.getBbplace());
			pstmt.setString(6, bb.getFilesrc());
			System.out.println(bb.getBbtitle());
			
			af=pstmt.executeUpdate();			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		pstmt.close();
		con.close();		
		
		return af;
		
	}

}
