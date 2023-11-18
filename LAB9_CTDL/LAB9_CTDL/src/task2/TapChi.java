package task2;

public class TapChi extends AnPham {
	private String tenTapChi;

	// Constructor
	public TapChi(String tieuDe, int soTrang, int namXuatBan, String tacGia, double giaTien, String tenTapChi) {
		super(tieuDe, soTrang, namXuatBan, tacGia, giaTien);
		this.tenTapChi = tenTapChi;
	}

	// Getters and Setters
	 

	@Override
	public String layLoaiAnPham() {
		return "Tap Chi";
	}

	public String getTenTapChi() {
		return tenTapChi;
	}

	public void setTenTapChi(String tenTapChi) {
		this.tenTapChi = tenTapChi;
	}

	@Override
	public boolean kiemTraTapChi10NamTruoc() {
		return this.namXuatBan == 2011;
	}
	
	
}
