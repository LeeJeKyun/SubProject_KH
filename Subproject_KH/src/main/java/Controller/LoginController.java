package Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dto.Member;
import Service.face.MemberService;
import Service.impl.MemberServiceImpl;

@WebServlet("/Login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private MemberService memberService = new MemberServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/Login [GET] TEst");
	
		req.getRequestDispatcher("/WEB-INF/views/Login.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		System.out.println("/Login Test [POST]");
		
		HttpSession session = req.getSession();
		
		String userid = req.getParameter("id");
		String userpw = req.getParameter("pw");
		
		Member user = new Member();
		user.setId(userid);
		user.setPw(userpw);
		System.out.println(user);
		
		// 테스트 완료
//		System.out.println("로그인 정보 추출 : " + userid + " : " + userpw);
		
		
		Member userChk = memberService.checkUser(user);
		
		System.out.println(userChk + "검증된 ID/pw 정보 ");
		
		
	
	}
	
	
}
