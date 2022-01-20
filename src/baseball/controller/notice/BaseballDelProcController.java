package baseball.controller.notice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import baseball.board.controller.Controller;
import baseball.dao.BaseballDao;

public class BaseballDelProcController implements Controller{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("========== < BaseballDelProcController > ==========");
		
		String bbno=request.getParameter("b");
		BaseballDao dao=new BaseballDao();
		int del=dao.delete(bbno);
		
		response.sendRedirect("baseballlist.do");
	}

}
