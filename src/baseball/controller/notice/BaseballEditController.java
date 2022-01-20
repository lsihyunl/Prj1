package baseball.controller.notice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import baseball.board.controller.Controller;
import baseball.dao.BaseballDao;
import baseball.vo.Baseball;

public class BaseballEditController implements Controller{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("========== < BaseballEditController > ==========");
		int bbno=Integer.parseInt(request.getParameter("b"));
		
		BaseballDao dao=new BaseballDao();
		Baseball b=dao.getBaseball(bbno);
		
		request.setAttribute("b", b);
		request.getRequestDispatcher("baseballEdit.jsp").forward(request, response);
	}

}
