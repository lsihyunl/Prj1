package baseball.controller.notice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import baseball.board.controller.Controller;

public class BaseballRegController implements Controller{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("========== < BaseballRegController > ==========");
		request.getRequestDispatcher("baseballReg.jsp").forward(request, response);
		
	}

}
