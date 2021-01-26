package soo.md.domain;

import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;
import soo.md.domain.Board;


@NoArgsConstructor //기본생성자
@Data  // setter getter
public class BoardListResult {
	private int cp;
	private long totalCount;
	private int ps;
	private List<Board> list;
	private long totalPageCount;
	
	public BoardListResult(int cp, long totalCount, int ps, List<Board> list) {
		this.cp = cp;
		this.totalCount = totalCount;
		this.ps = ps;
		this.list = list;
		this.totalPageCount = calTotalPageCount();
	}
	private long calTotalPageCount() {
		long tpc = totalCount/ps; 
		if(totalCount%ps != 0) tpc++;
		
		return tpc;
	}
}
