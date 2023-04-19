package kr.ac.kopo.library.member.ui;

import kr.ac.kopo.library.member.service.MemberService;
import kr.ac.kopo.library.ui.BaseUI;

public abstract class MemeberBaseUI extends BaseUI {
	
	protected MemberService service;

	protected MemeberBaseUI() {
		service = new MemberService();
	}

	
	
}
