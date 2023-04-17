package kr.ac.kopo.library.member.vo;

public class MemberVO {
	private String id;
	private String pwd;
	private String name;
	private String phone;

	public MemberVO() {
	}

	public MemberVO(String id, String pwd, String name, String phone) {
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.phone = phone;
	}

	public String getId() {
		return id;
	}

	public String getPwd() {
		return pwd;
	}

	public String getName() {
		return name;
	}

	public String getPhone() {
		return phone;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "MemberVO [id=" + id + ", pwd=" + pwd + ", name=" + name + ", phone=" + phone + "]";
	}

}
