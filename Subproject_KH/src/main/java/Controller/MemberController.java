package Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dto.Member;
import Service.face.MemberService;
import Service.impl.MemberServiceImpl;


@WebServlet("/member/join")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private MemberService memberService = new MemberServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// doGet Test
		System.out.println("doGet Test");
		
		// View Layer 넘기기
		req.getRequestDispatcher("/WEB-INF/views/Join.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//Post 테스트
		System.out.println("doPost Test");
		
		//저장 객체 생성
		Member newbie = new Member();
		
		//회원 정보 삽입
		newbie.setId(req.getParameter("id"));
		newbie.setPw(req.getParameter("pw"));
		newbie.setEmail(req.getParameter("mail"));
		
		Member result = memberService.regit(newbie);
		
		req.setAttribute("newbie", result);
		
		req.getRequestDispatcher("/WEB-INF/views/welcome.jsp").forward(req, resp);
		
	
	}
	

}
