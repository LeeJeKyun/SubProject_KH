package Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




@WebServlet("/callback")
public class NaverCallbackController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		System.out.println("Naver CallBack Test");
		
		req.getRequestDispatcher("/WEB-INF/views/callback.jsp").forward(req, resp);
	
	
	}
	
	
	
}
