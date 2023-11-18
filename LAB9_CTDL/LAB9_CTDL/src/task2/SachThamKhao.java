package task2;

import java.util.ArrayList;
import java.util.List;

public class SachThamKhao extends AnPham {
	private String linhVuc;
	private List<ChuongSach> danhSachChuong;

	public SachThamKhao(String tieuDe, int soTrang, int namXuatBan, String tacGia, double giaTien) {
		super(tieuDe, soTrang, namXuatBan, tacGia, giaTien);
		this.linhVuc = linhVuc;
		this.danhSachChuong = new ArrayList<>();
	}

	@Override
	public String layLoaiAnPham() {
		return "Sach Tham Khao";
	}

	public List<ChuongSach> getDanhSachChuong() {
		return danhSachChuong;
	}

	public void setDanhSachChuong(List<ChuongSach> danhSachChuong) {
		this.danhSachChuong = danhSachChuong;
	}

	// Phương thức thêm chương
	public void themChuong(ChuongSach chuong) {
		this.danhSachChuong.add(chuong);
	}



}
