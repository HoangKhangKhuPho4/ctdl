package task2;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.List;
import java.util.Map;

import org.junit.Test;

public class TestDanhMucAnPham {
	@Test
	public void testTinhTongTien() {

		DanhMucAnPham danhMuc = new DanhMucAnPham();

		danhMuc.themAnPham(new TapChi("Phụ nữ Việt Nam", 100, 2020, "Nguyễn Khắc Viện", 50.0, "PNVN"));

		danhMuc.themAnPham(new SachThamKhao("Lịch sử Việt Nam", 200, 2021, "Trần Trọng Kim", 75.0));

		double tongTienExpected = 125.0;

		assertEquals(tongTienExpected, danhMuc.tinhTongTien());

	}

	// Kiểm tra xem tạp chí có xuất bản 10 năm trước hay không.

	@Test
	public void testTapChi() {

		TapChi baoNhanDan = new TapChi("Báo Nhân Dân", 120, 2011, "Tô Hồng Việt", 65.0, "Nhandan");

		assertTrue(baoNhanDan.kiemTraTapChi10NamTruoc());

	}

	// Kiểm thử các phương thức khác như tìm sách tham khảo có chương nhiều trang
	// nhất
	@Test
	public void testDanhMucAnPham() {
		DanhMucAnPham danhMuc = new DanhMucAnPham();

		SachThamKhao sachLichSuVN = new SachThamKhao("Lịch sử Việt Nam", 500, 2021, "Trần Trọng Kim", 120.0);
		sachLichSuVN.themChuong(new ChuongSach("Thời Lý - Trần", 100));
		sachLichSuVN.themChuong(new ChuongSach("Thời Nguyễn", 150));

		danhMuc.themAnPham(sachLichSuVN);

		TapChi phuNuVietNam = new TapChi("Phụ nữ Việt Nam", 120, 2020, "Nguyễn Khắc Viện", 60.0, "PNVN");
		danhMuc.themAnPham(phuNuVietNam);

		assertEquals(sachLichSuVN, danhMuc.timSachThamKhaoChuongNhieuTrangNhat());

		assertTrue(danhMuc.kiemTraTonTaiTapChiTheoTen("PNVN"));

		Map<Integer, Integer> thongKe = danhMuc.thongKeAnPhamTheoNam();
		assertEquals(1, thongKe.get(2021).intValue());
		assertEquals(1, thongKe.get(2020).intValue());
	}

	// 6) Phương thức xác định loại của ấn phẩm (Tạp chí hay Sách tham khảo)
	@Test
	public void testCoPhaiLaSachThamKhao() {

		SachThamKhao sachLichSu = new SachThamKhao("Lịch sử Việt Nam", 500, 2022, "Trần Trọng Kim", 200.0);

		assertEquals("Sach Tham Khao", sachLichSu.layLoaiAnPham());

	}

	@Test
	public void testCoPhaiLaTapChi() {

		TapChi baoPhuNu = new TapChi("Báo Phụ nữ", 150, 2011, "Nguyễn Hữu Thống", 65.0, "PN");

		assertEquals("Tap Chi", baoPhuNu.layLoaiAnPham());

	}

	// 8) Phương thức kiểm tra hai ấn phẩm có cùng loại và cùng tác giả hay không

	@Test
	public void testKiemTraCungLoaiVaTacGia() {
		SachThamKhao sachTK1 = new SachThamKhao("Đắc nhân tâm", 300, 1936, "Dale Carnegie", 150.0);
		SachThamKhao sachTK2 = new SachThamKhao("NGHỆ THUẬT NÓI TRƯỚC CÔNG CHÚNG", 250, 1926, "Dale Carnegie", 120.0);
		TapChi tapChi1 = new TapChi("Tap Chi 1", 100, 2021, "Tac Gia Y", 55.0, "TC1");
		TapChi tapChi2 = new TapChi("Tap Chi 2", 120, 2022, "Tac Gia X", 60.0, "TC2");

		assertTrue(sachTK1.kiemTraCungLoaiVaTacGia(sachTK2)); // Cùng loại, cùng tác giả
		assertFalse(sachTK1.kiemTraCungLoaiVaTacGia(tapChi1)); // Khác loại, khác tác giả
		assertFalse(sachTK1.kiemTraCungLoaiVaTacGia(tapChi2)); // Khác loại, cùng tác giả
		assertFalse(tapChi1.kiemTraCungLoaiVaTacGia(tapChi2)); // Cùng loại, khác tác giả
	}

	// 11)Tìm xem trong danh sách các ấn phẩm có chứa một tạp chí có tên cho trước
//	hay không?
	@Test
	public void testKiemTraTonTaiTapChiTheoTen() {
		DanhMucAnPham danhMuc = new DanhMucAnPham();
		danhMuc.themAnPham(new SachThamKhao("Sach TK 1", 300, 2022, "Tac Gia A", 150.0));
		danhMuc.themAnPham(new TapChi("Tap Chi 1", 100, 2021, "Tac Gia B", 55.0, "TC1"));
		danhMuc.themAnPham(new TapChi("Tap Chi 2", 120, 2022, "Tac Gia C", 60.0, "TC2"));

		assertTrue(danhMuc.kiemTraTonTaiTapChiTheoTen("TC1")); // Có tạp chí "TC1" trong danh sách
		assertFalse(danhMuc.kiemTraTonTaiTapChiTheoTen("TC3")); // Không có tạp chí "TC3" trong danh sách
	}

	// 12)Lấy ra danh sách các tạp chí được xuất bản vào 1 năm cho trước
	@Test
	public void testLayTapChiTheoNamXuatBan() {
		DanhMucAnPham danhMuc = new DanhMucAnPham();
		danhMuc.themAnPham(new TapChi("Tap Chi 1", 100, 2020, "Tac Gia A", 50.0, "TC1"));
		danhMuc.themAnPham(new TapChi("Tap Chi 2", 120, 2021, "Tac Gia B", 60.0, "TC2"));
		danhMuc.themAnPham(new SachThamKhao("Sach TK", 300, 2021, "Tac Gia C", 70.0));

		List<TapChi> tapChis2020 = danhMuc.layTapChiTheoNamXuatBan(2020);
		assertEquals(1, tapChis2020.size());
		assertEquals("Tap Chi 1", tapChis2020.get(0).getTieuDe());

		List<TapChi> tapChis2021 = danhMuc.layTapChiTheoNamXuatBan(2021);
		assertEquals(1, tapChis2021.size());
		assertEquals("Tap Chi 2", tapChis2021.get(0).getTieuDe());
	}

	// 13)Sắp xếp ấn phẩm tăng dần theo tiêu đề và giảm dần theo năm xuất bản (sử
	// dụng interface Comparable hoặc Comparator)

	@Test
	public void testSapXepAnPham() {
		DanhMucAnPham danhMuc = new DanhMucAnPham();
		danhMuc.themAnPham(new TapChi("B Tap Chi", 100, 2021, "Tac Gia B", 60.0, "TC2"));
		danhMuc.themAnPham(new SachThamKhao("A Sach Tham Khao", 300, 2020, "Tac Gia A", 70.0));
		danhMuc.themAnPham(new TapChi("C Tap Chi", 120, 2019, "Tac Gia C", 50.0, "TC3"));

		danhMuc.sapXepAnPham();

		List<AnPham> danhSachDaSapXep = danhMuc.getDanhSachAnPham();
		assertEquals("A Sach Tham Khao", danhSachDaSapXep.get(0).getTieuDe());
		assertEquals(2020, danhSachDaSapXep.get(0).getNamXuatBan());
		assertEquals("B Tap Chi", danhSachDaSapXep.get(1).getTieuDe());
		assertEquals(2021, danhSachDaSapXep.get(1).getNamXuatBan());
		assertEquals("C Tap Chi", danhSachDaSapXep.get(2).getTieuDe());
		assertEquals(2019, danhSachDaSapXep.get(2).getNamXuatBan());
	}

	// 14)Thống kê số lượng ấn phẩm theo năm xuất bản. Ví dụ 2020: 5, 2021: 10, …
	// năm 2020 có 5 ấn phẩm, năm 2021 có 10 ấn phẩm.

	@Test
	public void testThongKeAnPhamTheoNam() {
		DanhMucAnPham danhMuc = new DanhMucAnPham();
		danhMuc.themAnPham(new TapChi("Tạp chí khoa học của Hiệp hội Khoa học Mỹ (AAAS)", 100, 2020,
				"Hiệp hội Khoa học Mỹ (American Association for the Advancement of Science - AAAS)", 50.0, "TC1"));
		danhMuc.themAnPham(new TapChi("Tạp chí y học lâu đời và uy tín của Anh", 120, 2020,
				"Hiệp hội Y khoa Massachusetts (Massachusetts Medical Society)", 60.0, "The Lancet"));
		danhMuc.themAnPham(new SachThamKhao("Sach TK 1", 200, 2021, "Tac Gia C", 70.0));
		danhMuc.themAnPham(new SachThamKhao("Sach TK 2", 300, 2021, "Tac Gia D", 80.0));
		danhMuc.themAnPham(new SachThamKhao("Sach TK 3", 250, 2021, "Tac Gia E", 90.0));

		Map<Integer, Integer> ketQuaThongKe = danhMuc.thongKeAnPhamTheoNam();

		assertEquals(Integer.valueOf(2), ketQuaThongKe.get(2020)); // 2 ấn phẩm trong năm 2020
		assertEquals(Integer.valueOf(3), ketQuaThongKe.get(2021)); // 3 ấn phẩm trong năm 2021
	}

}
