package soo.md.dao;

import java.util.List;

import soo.md.domain.Board;

public interface BoardDao {
	List<Board> list();
	void insert(Board board);
	Board content(long seq);
	void delete(long seq);
	Board update1(long seq);
	void update2(Board board);
}
