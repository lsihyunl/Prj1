package baseball.controller.notice;

import java.io.FileInputStream;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import baseball.board.controller.Controller;

public class DownloadController implements Controller{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("========== < DownloadController > ==========");
		
		String path=request.getParameter("p");
		String fname=request.getParameter("f");
		String urlPath=path+fname;
		System.out.println("urlPath : "+urlPath);
		String realPath=request.getServletContext().getRealPath(urlPath);
		System.out.println("realPath: "+realPath);
		
		response.setHeader("Content-Disposition", "attachment;filename="+new String(fname.getBytes(),"ISO8859_1"));
		//이미지인 경우 다운이 아닌 그냥 인터넷 창에서 오픈되기 때문에 윗줄을 추가하여 강제로 오픈 되지 않고 다운을 받도록 함
		
		FileInputStream fin=new FileInputStream(realPath);
		ServletOutputStream sout=response.getOutputStream();
		
		byte[] buf=new byte[1024];
		int size=0;
		while ((size=fin.read(buf, 0, 1024))!=-1) {
			sout.write(buf,0,size);
		}
		fin.close();
		sout.close();	
		
	}

}
