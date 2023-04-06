package Dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Common.JDBCTemplate;
import Dao.face.MemberDao;
import Dto.Member;

public class MemberDaoImpl implements MemberDao{

	PreparedStatement ps = null;
	ResultSet rs = null;
	
	@Override
	public int selectIDnum(Connection conn) {
		
		// idnum 저장 변수
		int idnum = 0;
		
		// SQL문 작성
		String sql = "";
		sql += "SELECT member_seq.nextval FROM dual";
		
		try {
			ps = conn.prepareStatement(sql);
			
			rs = ps.executeQuery();
			
			rs.next();
			
			idnum = rs.getInt(1);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		System.out.println("memberDaoImpl 단계 테스트");
		return idnum;
	}

	@Override
	public int insertMember(Connection conn, Member newbie) {
		
		// SQL 구문 작성
		String sql = "";
		sql += "INSERT INTO member ( id, pw, email, idnum )";
		sql += " VALUES ( ?, ?, ?, ? )";
		
		
		// insert 결과 저장
		int result = 0;
		
		try {
			// SQL 수행 객체 생성
			ps = conn.prepareStatement(sql);
			
			// 회원 정보 insert
			ps.setString(1, newbie.getId());
			ps.setString(2, newbie.getPw());
			ps.setString(3, newbie.getEmail());
			ps.setInt(4, newbie.getIdnum());
			
			// insert 결과 조회
			result = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(ps);
		}
		System.out.println("insertMember 단계 테스트");
		return result;
	}

	@Override
	public Member insertResult(Connection conn, int idnum) {
		
		//SQL 구문
		String sql = "";
		sql += "SELECT id, pw, email, idnum FROM MEMBER";
		sql += " WHERE idnum = ?";
		
		// 저장 객체 생성
		Member member = new Member();
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, idnum);
			
			rs = ps.executeQuery();
			
			while ( rs.next() ) {
				
				member.setId(rs.getString("id"));
				member.setPw(rs.getString("pw"));
				member.setEmail(rs.getString("email"));
				member.setIdnum(rs.getInt("idnum"));
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		System.out.println(member.getId() + "등록된 ID 확인 테스트");
		return member;
	}

	
	
	
	
	
	
	
	
	
	
}
