package baseball.board.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import baseball.board.controller.Controller;
import baseball.dao.MemberDao;
import baseball.vo.Member;

public class LoginProcController implements Controller{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		System.out.println("========== < LoginProcController > ==========");
		//로그인 처리
		String uid=request.getParameter("id");
		System.out.println(uid);
		String pwd=request.getParameter("password");
		System.out.println(pwd);
		
		MemberDao dao=new MemberDao();
		Member m=dao.getMember(uid);
		
		if(m==null) {//아이디 없음
			request.setAttribute("error", "아이디틀림");
			request.getRequestDispatcher("loginForm.jsp")
			.forward(request, response);
		}else if (!m.getPwd().equals(pwd)) {//비번틀림(느낌표가 있으니 일치하지 않으면)
			request.setAttribute("error", "비번틀림");
			request.getRequestDispatcher("loginForm.jsp")
			.forward(request, response);
		}else {//로그인 성공
			//아이디를 세션에 담기, notice.do진행
			request.getSession().setAttribute("uid",uid);
			response.sendRedirect("../baseballboard/baseballlist.do");
		}
		
	}

	
	
}