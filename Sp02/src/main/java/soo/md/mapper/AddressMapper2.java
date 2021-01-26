package soo.md.mapper;

import java.util.List;

import soo.md.domain.Address;

public interface AddressMapper2 {
	List<Address> list();
	void insert(Address address);
	void delete(long seq);
}


//AddressMapper1  <java>  AddressMapper1 <resources>로 DAO를 따로 만들 필요가없다.