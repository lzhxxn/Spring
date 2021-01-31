package soo.md.service;

import org.springframework.stereotype.Service;

@Service
public class SampleLogServiceImpl implements SampleLogService {

	@Override
	public int add(String str1, String str2) throws Exception {  //종적관심
		int i1 = Integer.parseInt(str1);
		int i2 = Integer.parseInt(str2);
		
		return i1 + i2;
	}

}
