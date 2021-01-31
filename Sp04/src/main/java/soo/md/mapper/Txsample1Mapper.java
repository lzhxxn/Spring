package soo.md.mapper;

import org.apache.ibatis.annotations.Insert;

public interface Txsample1Mapper {
	@Insert("insert into tbl_sample1 values(#{data})")  //데이터자리X 컬럼자리O => ${catgo}
	public int insertCol1(String data);
	
}
