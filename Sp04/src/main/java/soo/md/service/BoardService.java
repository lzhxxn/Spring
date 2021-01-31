package soo.md.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import soo.md.domain.Board;
import soo.md.domain.BoardListResult;
import soo.md.domain.BoardVo;

public interface BoardService {
	BoardListResult getBoardListResult(int cp, int ps);
	BoardListResult getBoardListResult(String catgo, String keyword, int cp, int ps);  //keyword 추가로 받으면 where 조건절이 생긴다.  서비스랑 Mapper랑 같을 필요가없다. 이름이
	List<Board> listS();
	void insertS(Board board);  //클라이언트가요청하는거기때문에 write로 바꿔줘도된다. 
	void insertreS(Board board);  //클라이언트가요청하는거기때문에 write로 바꿔줘도된다. 
	Board selectBySeqS(long seq);
	void deleteS(long seq);   //remove
	Board update1S(long seq);
	void update2S(Board board); //edit
	
	boolean writeFile(MultipartFile file, String saveFileName);
	String saveStore(MultipartFile file);	
}
