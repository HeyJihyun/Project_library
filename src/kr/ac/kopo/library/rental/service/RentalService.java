package kr.ac.kopo.library.rental.service;

import java.util.List;

import kr.ac.kopo.library.rental.dao.RentalDAO;
import kr.ac.kopo.library.rental.vo.RentalVO;

public class RentalService {
	private RentalDAO rentalDao;
	
	public RentalService() {
		rentalDao = new RentalDAO();
	}

	public void insertRental(RentalVO vo) {
		rentalDao.insertRental(vo);
	}
	
	public List<RentalVO> getRState(String id){
		return rentalDao.getRState(id);
	}
	
	public int returnRental(String id, int b_no) {
		return rentalDao.returnRental(id, b_no);
	}
	
	public int extension(String id, int b_no) {
		return rentalDao.extension(id, b_no);
	}

}
