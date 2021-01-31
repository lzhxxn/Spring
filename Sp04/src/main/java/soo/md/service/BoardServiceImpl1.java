package soo.md.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import soo.md.domain.Board;
import soo.md.domain.BoardListResult;
import soo.md.domain.BoardVo;
import soo.md.filesetting.Path;
import soo.md.mapper.BoardMapper;

@Service("boardService1")
@AllArgsConstructor
@Log4j

public class BoardServiceImpl1 implements BoardService {
	
	@Resource
	private BoardMapper boardMapper; // Spring 4.3 부터 가능하다. AutoInjection ( with @AllArgsConstructor ) 19번 줄 빼주면된다. @AllArgsConstructor을 써주면.
	
	@Override
	public BoardListResult getBoardListResult(int cp, int ps) {
		long totalCount = boardMapper.selectCount();
		BoardVo boardVo = new BoardVo(null, null, cp, ps);
		List<Board> list = boardMapper.selectPerPage(boardVo);

		return  new BoardListResult(cp, totalCount, ps, list);
	}
	// 인터페이스 메서드 앞에는 public abstract가 생략되어있다. 자식메소드의 접근제한자가 부모메소드의 접근제한자보다 같거나 넓어야한다.
	@Override    //가독성 구분역할 (부모로부터 상속 받은 것 : 오버라이드)  
	public BoardListResult getBoardListResult(String catgo, String keyword, int cp, int ps) {    //파라미터로 구분할수있으니까 안써줘도된다. 
		BoardVo boardVo = new BoardVo(catgo, keyword, cp, ps);
		long totalCount = boardMapper.selectCountByCatgo(boardVo);
		List<Board> list = boardMapper.selectByCatgo(boardVo);
		
		return new BoardListResult(cp, totalCount, ps, list);
	}
	
	@Override
	public List<Board> listS() {
		return boardMapper.list();
	}

	@Override
	public void insertS(Board board) {
		boardMapper.insert(board);
	}
	@Override
	public void insertreS(Board board) {
		boardMapper.insert_re(board);
	}

	@Override
	public Board selectBySeqS(long seq) {
		return boardMapper.selectBySeq(seq);
	}

	@Override
	public void deleteS(long seq) {
		boardMapper.delete(seq);
	}

	@Override
	public Board update1S(long seq) {
		return boardMapper.update1(seq);
	}

	@Override
	public void update2S(Board board) {
		boardMapper.update2(board);  
	}
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
		String fname = sb.toString();    // String result = "abc_123456.jpg"
		
		long fsize = file.getSize();
		log.info("#ofname: " + ofname + ", saveFileName: "+ fname +", fsize : "+ fsize);
		
		boolean flag = writeFile(file, fname);
		if(flag) {
			log.info("#업로드 성공");
		}else {
			log.info("#업로드 실패");
		}
		return Path.FILE_STORE + fname;
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
