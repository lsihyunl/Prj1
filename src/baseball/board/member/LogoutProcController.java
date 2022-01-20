package baseball.board.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import baseball.board.controller.Controller;

public class LogoutProcController implements Controller{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("========== < LogoutProcController > ==========");
		//로그아웃 처리
		request.getSession().invalidate();
		response.sendRedirect("../baseballbord/baseballlist.do");
		
	}
	
}
