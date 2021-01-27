package soo.md.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.log4j.Log4j;
import soo.md.filesetting.Path;

@Log4j
@Service
public class FileUploadServiceImpl implements FileUploadService {

	@Override
	public String saveStore(MultipartFile file) {
		String ofname = file.getOriginalFilename();
		int idx = ofname.lastIndexOf(".");    // 인덱스를 찾아온다. 0 1        abc.jpg
		String ofheader = ofname.substring(0, idx); // 0이상 idx파일미만.    abc.jpg
		String ext = ofname.substring(idx);
		long ms = System.currentTimeMillis();    //1970.1.1 0시부터 밀리세컨드단위 1000분의 1초로 현재시간까지 가져온다. 다른 파일과 겹치지않게 도와준다.
		StringBuilder sb = new StringBuilder(); // abc _ 123456.jpg
		sb.append(ofheader);
		sb.append("_");
		sb.append(ms);
		sb.append(ext);
		String saveFileName = sb.toString();    // String result = "abc_123456.jpg"
		
		long fsize = file.getSize();
		log.info("#ofname: " + ofname + ", saveFileName: "+ saveFileName +", fsize : "+ fsize);
		
		boolean flag = writeFile(file, saveFileName);
		if(flag) {
			log.info("#업로드 성공");
		}else {
			log.info("#업로드 실패");
		}
		return Path.FILE_STORE + saveFileName;
	}

	@Override
	public boolean writeFile(MultipartFile file, String saveFileName) {
		File rDir = new File(Path.FILE_STORE);
		if(!rDir.exists()) rDir.mkdirs();
		
		FileOutputStream fos = null;
		try {
		byte data[] = file.getBytes();
		fos = new FileOutputStream(Path.FILE_STORE+saveFileName);
		fos.write(data);
		fos.flush();
		
		return true;
		}catch(IOException ie) {
			return false;
		}finally {
			try {
				if(fos != null) fos.close();
			}catch(IOException ie) {}
		}
		
	}
}

