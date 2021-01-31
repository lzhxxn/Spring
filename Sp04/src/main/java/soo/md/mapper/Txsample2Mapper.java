package soo.md.mapper;

import org.apache.ibatis.annotations.Insert;

public interface Txsample2Mapper {
	@Insert("insert into tbl_sample2 values(#{data})")  //데이터자리X 컬럼자리O => ${catgo}
	public int insertCol2(String data);
}
