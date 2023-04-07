package Dao.face;

import java.sql.Connection;

import Dto.Member;

public interface MemberDao {

	/**
	 * 회원가입 시 회원번호 조회 
	 * @param conn - DB 연결 객체
	 * @return - 회원 가입 시 DB의 회원번호의 다음 시퀀스 값
	 */
	public int selectIDnum(Connection conn);

	/**
	 * 회원번호가 지정된 회원 정보에 대한
	 * 회원 가입, DB 회원 정보 저장
	 * @param conn - DB 연결 객체
	 * @param newbie - 신입 회원 정보
	 * @return - DB insert 결과 1이면 성공 0이면 실패
	 */
	public int insertMember(Connection conn, Member newbie);

	/**
	 * 회원가입이 완료됐는지 확인
	 * @param conn - DB 연결 객체
	 * @param idnum 
	 * @return - 회원가입이 완료된 회원 정보
	 */
	public Member insertResult(Connection conn, int idnum);

	/**
	 * 로그인 시도 중인 회원정보를 
	 * DB에서 검색해 ID,PW를 확인한다
	 * 
	 * @param conn - DB 연결 객체
	 * @param user - 로그인 시도 중인 회원 정보
	 * @return - DB에 있는 회원 정보
	 */
	public Member selectUser(Connection conn, Member user);

}
