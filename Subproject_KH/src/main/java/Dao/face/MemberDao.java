package Dao.face;

import java.sql.Connection;

import Dto.Member;

public interface MemberDao {

	public int selectIDnum(Connection conn);

	public int insertMember(Connection conn, Member newbie);

}
