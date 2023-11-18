package task2;

public abstract class AnPham {
	protected String tieuDe;
	protected int soTrang;
	protected int namXuatBan;
	protected String tacGia;
	protected double giaTien;

	public int getNamXuatBan() {
		return namXuatBan;
	}

	public void setNamXuatBan(int namXuatBan) {
		this.namXuatBan = namXuatBan;
	}

	// Constructor
	public AnPham(String tieuDe, int soTrang, int namXuatBan, String tacGia, double giaTien) {
		this.tieuDe = tieuDe;
		this.soTrang = soTrang;
		this.namXuatBan = namXuatBan;
		this.tacGia = tacGia;
		this.giaTien = giaTien;
	}

	// Getters and Setters
	

	// Phương thức trừu tượng để xác định loại ấn phẩm
	public abstract String layLoaiAnPham();

	public double getGiaTien() {
		return giaTien;
	}

	public String getTieuDe() {
		return tieuDe;
	}

	public void setTieuDe(String tieuDe) {
		this.tieuDe = tieuDe;
	}

	public void setGiaTien(double giaTien) {
		this.giaTien = giaTien;
	}

	// Phương thức kiểm tra ấn phẩm là tạp chí xuất bản cách đây 10 năm
	public boolean kiemTraTapChi10NamTruoc() {
		return false;
	}

	// Phương thức kiểm tra cùng loại và tác giả
	public boolean kiemTraCungLoaiVaTacGia(AnPham anPhamKhac) {
		return this.layLoaiAnPham().equals(anPhamKhac.layLoaiAnPham()) && this.tacGia.equals(anPhamKhac.tacGia);
	}
	
	
}
