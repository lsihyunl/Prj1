package baseball.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import baseball.board.member.LoginController;
import baseball.board.member.LoginProcController;
import baseball.board.member.LogoutProcController;
import baseball.controller.notice.BaseballController;
import baseball.controller.notice.BaseballDelProcController;
import baseball.controller.notice.BaseballDetailController;
import baseball.controller.notice.BaseballEditController;
import baseball.controller.notice.BaseballEditProcController;
import baseball.controller.notice.BaseballRegProcController;
import baseball.controller.notice.BaseballRegController;
import baseball.controller.notice.DownloadController;



public class MyDispatcher extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		System.out.println("============ < MyDispatcher In > ============");
		String uri=request.getRequestURI();
		String conPath=request.getContextPath();
		String com=uri.substring(conPath.length());
		
		System.out.println("uri: "+uri);
		System.out.println("conPath: "+conPath);
		System.out.println("com: "+com);
		
		Controller controller=null;
		
		try {
			if (com.equals("/baseballboard/baseballlist.do")) {
				controller=new BaseballController();
			} else if (com.equals("/baseballboard/baseballDetail.do")) {
				controller=new BaseballDetailController();
			} else if (com.equals("/baseballboard/baseballDelProc.do")) {
				controller=new BaseballDelProcController();
			} else if (com.equals("/baseballboard/baseballEdit.do")) {
				controller=new BaseballEditController(); 
			} else if (com.equals("/baseballboard/baseballEditProc.do")) {
				controller=new BaseballEditProcController(); 
			} else if (com.equals("/baseballboard/baseballReg.do")) {
				controller=new BaseballRegController(); 
			} else if (com.equals("/baseballboard/baseballRegProc.do")) {
				controller=new BaseballRegProcController(); 
			}  else if (com.equals("/login/login.do")){
				controller=new LoginController();
			} else if (com.equals("/login/loginProc.do")){
				controller=new LoginProcController();
			} else if (com.equals("/login/logoutProc.do")){
				controller=new LogoutProcController();
			} else if (com.equals("/baseballboard/download.do")){
				controller=new DownloadController();
			}												
			controller.execute(request,response);
		} catch (Exception e) {
			
		}
		
		
	}

}
