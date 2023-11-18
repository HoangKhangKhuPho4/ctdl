package task2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DanhMucAnPham {
	private List<AnPham> danhSachAnPham;

	// Constructor
	public DanhMucAnPham() {
		this.danhSachAnPham = new ArrayList<>();
	}

	// Phương thức tính tổng tiền của tất cả ấn phẩm
	public double tinhTongTien() {
		double tongTien = 0.0;
		for (AnPham anPham : danhSachAnPham) {
			tongTien += anPham.getGiaTien();
		}
		return tongTien;
	}

	public List<AnPham> getDanhSachAnPham() {
		return danhSachAnPham;
	}

	public void setDanhSachAnPham(List<AnPham> danhSachAnPham) {
		this.danhSachAnPham = danhSachAnPham;
	}

	// Phương thức tìm sách tham khảo có chương nhiều trang nhất
	public SachThamKhao timSachThamKhaoChuongNhieuTrangNhat() {
		SachThamKhao sachTimThay = null;
		int soTrangLonNhat = 0;

		for (AnPham anPham : danhSachAnPham) {
			if (anPham instanceof SachThamKhao) {
				SachThamKhao sachThamKhao = (SachThamKhao) anPham;
				for (ChuongSach chuong : sachThamKhao.getDanhSachChuong()) {
					if (chuong.getSoTrangChuong() > soTrangLonNhat) {
						soTrangLonNhat = chuong.getSoTrangChuong();
						sachTimThay = sachThamKhao;
					}
				}
			}
		}
		return sachTimThay;
	}

	// Phương thức kiểm tra xem có tạp chí với tên cho trước trong danh sách hay
	// không
	public boolean kiemTraTonTaiTapChiTheoTen(String tenTapChi) {
		for (AnPham anPham : danhSachAnPham) {
			if (anPham instanceof TapChi && ((TapChi) anPham).getTenTapChi().equalsIgnoreCase(tenTapChi)) {
				return true;
			}
		}
		return false;
	}

	// Phương thức lấy ra danh sách các tạp chí được xuất bản trong một năm cụ thể
	public List<TapChi> layTapChiTheoNamXuatBan(int nam) {
		List<TapChi> tapChiTheoNam = new ArrayList<>();
		for (AnPham anPham : danhSachAnPham) {
			if (anPham instanceof TapChi && anPham.getNamXuatBan() == nam) {
				tapChiTheoNam.add((TapChi) anPham);
			}
		}
		return tapChiTheoNam;
	}

	// Phương thức sắp xếp ấn phẩm tăng dần theo tiêu đề và giảm dần theo năm xuất
	// bản
	public void sapXepAnPham() {
		Collections.sort(danhSachAnPham, new Comparator<AnPham>() {
			@Override
			public int compare(AnPham o1, AnPham o2) {
				int tieuDeCompare = o1.getTieuDe().compareToIgnoreCase(o2.getTieuDe());
				if (tieuDeCompare != 0) {
					return tieuDeCompare; // Sắp xếp tăng dần theo tiêu đề
				} else {
					return o2.getNamXuatBan() - o1.getNamXuatBan(); // Sắp xếp giảm dần theo năm xuất bản
				}
			}
		});
	}

	// Phương thức thống kê số lượng ấn phẩm theo năm xuất bản
	public Map<Integer, Integer> thongKeAnPhamTheoNam() {
		Map<Integer, Integer> thongKe = new HashMap<>();
		for (AnPham anPham : danhSachAnPham) {
			int namXuatBan = anPham.getNamXuatBan();
			thongKe.put(namXuatBan, thongKe.getOrDefault(namXuatBan, 0) + 1);
		}
		return thongKe;
	}

	// Phương thức thêm ấn phẩm vào danh sách
	public void themAnPham(AnPham anPham) {
		danhSachAnPham.add(anPham);
	}

}
