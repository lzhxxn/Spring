package soo.md.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import soo.md.domain.Address;
import soo.md.dao.AddressDao;


@Service("addressService")  //로직은다르지만 이름을 달리해서 구분해줘야한다.
public class AddressServiceImpl implements AddressService {
	@Autowired
	private AddressDao addressDao;
	@Override
	public List<Address> listS() {
		return addressDao.list();
	}

	@Override
	public void insertS(Address address) {
		addressDao.insert(address);

	}

	@Override
	public void deleteS(long seq) {
		addressDao.delete(seq);
		
	}

}
