package soo.md.mapper;

import java.util.List;
import soo.md.domain.Address;

public interface AddressAjaxMapper {
	List<Address> list();
	void insert(Address address);
	void delete(long seq);
	
	//for Ajax
	Address selectBySeq(long seq);
	List<Address> selectByName(String name);
}
