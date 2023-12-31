package entity;

public class NhaXuatBan {
	private String maNXB;
	private String tenNXB;
	private String diaChi;
	public NhaXuatBan() {
		super();
	}
	
	public NhaXuatBan(String tenNXB) {
		super();
		this.tenNXB = tenNXB;
	}

	public NhaXuatBan(String maNXB, String tenNXB, String diaChi) {
		super();
		this.maNXB = maNXB;
		this.tenNXB = tenNXB;
		this.diaChi = diaChi;
	}
	public String getMaNXB() {
		return maNXB;
	}
	public void setMaNXB(String maNXB) {
		this.maNXB = maNXB;
	}
	public String getTenNXB() {
		return tenNXB;
	}
	public void setTenNXB(String tenNXB) {
		this.tenNXB = tenNXB;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	@Override
	public String toString() {
		return "NhaXuatBan [maNXB=" + maNXB + ", tenNXB=" + tenNXB + ", diaChi=" + diaChi + "]";
	}
	
	
	
}
