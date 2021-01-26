package soo.md.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import soo.md.domain.Address;
import soo.md.mapper.AddressMapper2;

@Service("addressService2") //로직은다르지만 이름을 달리해서 구분해줘야한다.  //구현객체가 하나면 안만들어줘도된다.
public class AddressServiceImpl2 implements AddressService {
	
	//@Autowired	// new AddressMapperImpl 객체를 스프링자체에서 만들어준다.
	@Resource
	private AddressMapper2 addressMapper;   //이클래스에서 쓰이는 멤버변수여서 상관없다. 1을 붙이든 말든.
	
	@Override
	public List<Address> listS() {
		return addressMapper.list();
	}

	@Override
	public void insertS(Address address) {
		addressMapper.insert(address);

	}

	@Override
	public void deleteS(long seq) {
		addressMapper.delete(seq);

	}

}
