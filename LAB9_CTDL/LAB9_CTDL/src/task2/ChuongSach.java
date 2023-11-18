package task2;

public class ChuongSach {
	private String tieuDeChuong;
	private int soTrangChuong;

	// Constructor
	public ChuongSach(String tieuDeChuong, int soTrangChuong) {
		this.tieuDeChuong = tieuDeChuong;
		this.soTrangChuong = soTrangChuong;
	}

	// Getters and Setters
	public int getSoTrangChuong() {
		return soTrangChuong;
	}

	public void setSoTrangChuong(int soTrangChuong) {
		this.soTrangChuong = soTrangChuong;
	}

	public String getTieuDeChuong() {
		return tieuDeChuong;
	}

	public void setTieuDeChuong(String tieuDeChuong) {
		this.tieuDeChuong = tieuDeChuong;
	}

}
