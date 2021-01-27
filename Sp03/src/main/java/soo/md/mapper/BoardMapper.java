package soo.md.mapper;

import java.util.List;

import soo.md.domain.Board;
import soo.md.domain.BoardVo;

public interface BoardMapper {
	List<Board> list();
	
	List<Board> selectPerPage(BoardVo boardVo);
	List<Board> selectByCatgo(BoardVo boardVo);
	
	Board selectBySeq(long seq);
	long selectCount();
	long selectCountByCatgo(BoardVo boardVo);  //두개이상이니까 String X
	
	void insert(Board board);
	void insert_re(Board board);
	void delete(long seq);
	Board update1(long seq);
	void update2(Board board);
}


//BoardMapper  <java>  BoardMapper <resources>로 DAO를 따로 만들 필요가없다.