package soo.md.service;

import java.util.List;

import javax.annotation.Resource;
import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j;
import soo.md.dao.AddressDao;
import soo.md.domain.Address;

@Log4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class TxSampleServiceTests {
	@Autowired
	private TxSampleService service;
	
	@Test
	public void testAddDatas() { //addDatas 이 메서드를 테스트를 해라~
		String data = "여행";
		//String data = "어떻게 눈물이 차올라서 고개를 들어 흐르지 못하게 또 살짝 웃어";

		long len = data.getBytes().length; //바이트수가나온다.
		log.info("#입력된 바이트수 : " + len);
		
		service.addDatas(data);
	}
}
