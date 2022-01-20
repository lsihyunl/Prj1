package baseball.controller.notice;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import baseball.board.controller.Controller;
import baseball.dao.BaseballDao;
import baseball.vo.Baseball;

public class BaseballController implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		System.out.println("========== < BaseballController > ==========");
		
		String field=request.getParameter("f");
		System.out.println("field : "+field);
		if(field==null || field.equals(""))
			field="bbtitle";
		
		
		String query=request.getParameter("q");
		System.out.println("query : "+query);
		if(query==null)
			query="";
		
		BaseballDao dao=new BaseballDao();
		List<Baseball> list=dao.baseSelall(field, query);
		request.setAttribute("list", list);
		request.setAttribute("query", query);
		request.getRequestDispatcher("baseballlist.jsp").forward(request, response);
		
	}

}
