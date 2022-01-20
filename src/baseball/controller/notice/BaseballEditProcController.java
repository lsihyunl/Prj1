package baseball.controller.notice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import baseball.board.controller.Controller;
import baseball.dao.BaseballDao;
import baseball.vo.Baseball;

public class BaseballEditProcController implements Controller{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		System.out.println("========== < BaseballEditProcController > ==========");
		int bbno=Integer.parseInt(request.getParameter("b"));
		String bbtitle=request.getParameter("bbtitle");
		String bbdate=request.getParameter("bbdate");
		String bbcontent=request.getParameter("bbcontent");
		String file=request.getParameter("file");
		System.out.println("1111");
		
		Baseball b=new Baseball();
		b.setBbno(bbno);
		b.setBbtitle(bbtitle);
		b.setBbdate(bbdate);
		b.setBbcontent(bbcontent);
		b.setFilesrc(file);
		System.out.println("filesrc: "+file);
		
		BaseballDao dao=new BaseballDao();
		int af=dao.update(b);
		b=dao.getBaseball(bbno);
		
		request.setAttribute("b", b);
		request.getRequestDispatcher("baseballDetail.jsp").forward(request, response);
	}

}
