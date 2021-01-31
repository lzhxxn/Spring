package soo.md.filesetting;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.util.FileCopyUtils;
import org.springframework.web.servlet.view.AbstractView;

import lombok.extern.log4j.Log4j;

@Log4j
public class FileDownloadView extends AbstractView { // View역할을 하는 JSP같은 것이다.
	public FileDownloadView() {
		setContentType("application/download;charset=utf-8");
	}
	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		File file =  (File)model.get("downloadFile"); // Object로 넘어와서 File 타입으로 다시 만들어줘야한다.
		
		response.setContentType(getContentType());
		response.setContentLength((int)file.length());
		String value = "attachment; filename="+ java.net.URLEncoder.encode(file.getName(), "utf-8") +";";
		 //브라우저가 서로  http정의서 대화를 주고받는 내용 ! !
		response.setHeader("Content-Disposition", value);
	    response.setHeader("Content-Transfer-Encoding", "binary");
	    
	    OutputStream os = response.getOutputStream();
	    FileInputStream fis = null;
	    try {
	    	fis = new FileInputStream(file);
	    	FileCopyUtils.copy(fis, os); //fis -> os에 복사해라!  반복문을 안써도된다. 
	    	
	    	os.flush();
	    }catch(IOException ie) {
	    	log.info("FileDownloadView ie: " + ie);
	    }finally {
	    	if(fis != null) fis.close();
	    	if(os != null) os.close();
	    }
	}
}
