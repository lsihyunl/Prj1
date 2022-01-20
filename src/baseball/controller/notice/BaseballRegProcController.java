package baseball.controller.notice;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import baseball.board.controller.Controller;
import baseball.dao.BaseballDao;
import baseball.vo.Baseball;

public class BaseballRegProcController implements Controller{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		System.out.println("========== < BaseballRegProcController > ==========");
		
		String path="baseballboard/upload";
		ServletContext ctx=request.getServletContext();
		path=ctx.getRealPath(path);
		System.out.println("real path~~~: "+path);
		
		MultipartRequest req=new MultipartRequest(request, path, 10*1024*1024,"utf-8", new DefaultFileRenamePolicy());
		System.out.println("확인확인");
		
		String bbtitle=req.getParameter("bbtitle");
		System.out.println("bbtitle :"+bbtitle);
		String bbcontent=req.getParameter("bbcontent");
		String bbdate=req.getParameter("bbdate");
		String bbday=req.getParameter("bbday");
		String bbplace=req.getParameter("bbplace");
		String file=req.getFilesystemName("file");
		
		System.out.println("bbtitle: "+bbtitle);
		System.out.println("filesrc: "+file);
		
		Baseball bb=new Baseball();
		bb.setBbtitle(bbtitle);
		bb.setBbcontent(bbcontent);
		bb.setBbdate(bbdate);
		bb.setBbday(bbday);
		bb.setBbplace(bbplace);
		bb.setFilesrc(file);
		
		BaseballDao dao=new BaseballDao();
		int af=dao.write(bb);
		
		response.sendRedirect("baseballlist.do");
	}

}
