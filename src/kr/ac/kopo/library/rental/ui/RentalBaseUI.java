package kr.ac.kopo.library.rental.ui;

import kr.ac.kopo.library.rental.service.RentalService;
import kr.ac.kopo.library.ui.BaseUI;

public abstract class RentalBaseUI extends BaseUI {
	
	protected RentalService service;

	protected RentalBaseUI() {
		service = new RentalService();
	}

	
	
}
