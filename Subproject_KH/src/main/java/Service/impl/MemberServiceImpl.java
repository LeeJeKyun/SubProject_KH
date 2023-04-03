package Service.impl;

import java.sql.Connection;

import Common.JDBCTemplate;
import Dao.face.MemberDao;
import Dao.impl.MemberDaoImpl;
import Dto.Member;
import Service.face.MemberService;

public class MemberServiceImpl implements MemberService{

	private MemberDao memberDao = new MemberDaoImpl();
	
	@Override
	public Member regit(Member newbie) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		// idnum 시퀀스 조회
		int idnum = memberDao.selectIDnum(conn);
		
		// idnum 시퀀스 삽입
		newbie.setIdnum(idnum);
		
		// insert 
		int rgit = memberDao.insertMember(conn, newbie);
		
		// insert 성공 시 commit, 실패 시 rollback;
		if ( rgit > 0 ) {
//			conn.commit();
		} else {
//			conn.rollback();
		}
		
		Member result = new Member();
		
		
		return result;
	}

}
