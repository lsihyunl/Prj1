package baseball.controller.notice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import baseball.board.controller.Controller;
import baseball.dao.BaseballDao;
import baseball.vo.Baseball;

public class BaseballDetailController implements Controller{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("========== < BallingDetailController > ==========");
		String bbno=request.getParameter("b");
		//이 b가 어디서 나왔느냐! baseballDetail에 b= 이 값이다.
		String bbhit=request.getParameter("h");
		System.out.println(bbhit+"123");
		
		BaseballDao dao=new BaseballDao();
		System.out.println("666");
		Baseball b=dao.getBaseball(bbno,bbhit);
		System.out.println("123");
		
		request.setAttribute("b", b);
		request.getRequestDispatcher("baseballDetail.jsp").forward(request, response);
		
	}

}
