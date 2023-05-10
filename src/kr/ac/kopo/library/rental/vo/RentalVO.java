package kr.ac.kopo.library.rental.vo;

public class RentalVO {

    private int b_no;
    private String u_id;
    private String title;
    private String rental_date;
    private String return_date;
    private int extension;

    public RentalVO() {
    }

    public RentalVO(int b_no, String u_id, String title, String rental_date, String return_date, int extension) {
        super();
        this.b_no = b_no;
        this.u_id = u_id;
        this.title = title;
        this.rental_date = rental_date;
        this.return_date = return_date;
        this.extension = extension;
    }

    public int getB_no() {
        return b_no;
    }

    public String getU_id() {
        return u_id;
    }

    public String getTitle() {
        return title;
    }

    public String getRental_date() {
        return rental_date;
    }

    public String getReturn_date() {
        return return_date;
    }

    public int getExtension() {
        return extension;
    }

    public void setB_no(int b_no) {
        this.b_no = b_no;
    }

    public void setU_id(String u_id) {
        this.u_id = u_id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setRental_date(String rental_date) {
        this.rental_date = rental_date;
    }

    public void setReturn_date(String return_date) {
        this.return_date = return_date;
    }

    public void setExtension(int extension) {
        this.extension = extension;
    }

    @Override
    public String toString() {
        return "RentalVO [b_no=" + b_no + ", u_id=" + u_id + ", title=" + title + ", rental_date=" + rental_date
                + ", return_date=" + return_date + ", extension=" + extension + "]";
    }

}
