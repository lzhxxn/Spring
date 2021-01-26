package soo.md.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import lombok.Setter;
import lombok.extern.log4j.Log4j;
import soo.md.domain.BoardListResult;

@Log4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class BoardServiceTests {
	@Setter(onMethod_ = {@Autowired})
	private BoardService boardService;
	
	@Test
	public void testList() {
		String catgo = "subject";
		String keyword = "제목1";
		int cp = 1;
		int ps = 5;
		BoardListResult listResult = boardService.getBoardListResult(catgo, keyword, cp, ps);
	    log.info("@testList() listResult: " + listResult);
	    log.info("@testList() totalCount: " + listResult.getTotalCount());
	}
}
