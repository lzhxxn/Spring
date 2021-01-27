package soo.md.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class SampleLogServiceTests {
	@Setter(onMethod_ = {@Autowired})
	private SampleLogService service;
	
	/*
	@Test
	public void testAdd() throws Exception {
		int result = service.add("10", "20");
	    log.info("#testAdd() result: " + result);
	}*/

	@Test
	public void testAddError() throws Exception {
	    log.info(service.add("10", "호랑이"));
	}
}
