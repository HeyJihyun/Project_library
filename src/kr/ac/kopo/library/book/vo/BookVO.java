package kr.ac.kopo.library.book.vo;

public class BookVO {

	private int b_no;
	private String title;
	private String writer;
	private String reg_date;
	private String pub_date;
	private String publisher;
	private String genre;
	private String r_state;

	public BookVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BookVO(int b_no, String title, String writer, String reg_date, String pub_date, String publisher,
			String genre, String r_state) {
		super();
		this.b_no = b_no;
		this.title = title;
		this.writer = writer;
		this.reg_date = reg_date;
		this.pub_date = pub_date;
		this.publisher = publisher;
		this.genre = genre;
		this.r_state = r_state;
	}

	public String getR_state() {
		return r_state;
	}

	public void setR_state(String r_state) {
		this.r_state = r_state;
	}

	public int getB_no() {
		return b_no;
	}

	public String getTitle() {
		return title;
	}

	public String getWriter() {
		return writer;
	}

	public String getReg_date() {
		return reg_date;
	}

	public String getPub_date() {
		return pub_date;
	}

	public String getPublisher() {
		return publisher;
	}

	public String getGenre() {
		return genre;
	}

	public void setB_no(int b_no) {
		this.b_no = b_no;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public void setReg_date(String reg_date) {
		this.reg_date = reg_date;
	}

	public void setPub_date(String pub_date) {
		this.pub_date = pub_date;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	@Override
	public String toString() {
		return "BookVO [b_no=" + b_no + ", title=" + title + ", writer=" + writer + ", reg_date=" + reg_date
				+ ", pub_date=" + pub_date + ", publisher=" + publisher + ", genre=" + genre + ", r_state=" + r_state
				+ "]";
	}



}
