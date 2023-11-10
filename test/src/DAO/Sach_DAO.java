package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ConnectDB.ConnectDB;
import entity.KhachHang;
import entity.NhaCungCap;
import entity.NhaXuatBan;
import entity.Sach;
import entity.TacGia;
import entity.TheLoai;




public class Sach_DAO {
	ArrayList<entity.Sach> dsSach;
	public Sach_DAO() {
		dsSach = new ArrayList<Sach>();

	}	
	
public List<Sach> getAllSach(){
		
		ArrayList<Sach> dss=new ArrayList<Sach>();
		
		try {
			ConnectDB.getInstance();
			Connection con=ConnectDB.getConnection();
			String sql="select Sach.maSach,Sach.tenSach,NhaCungCap.tenNCC,Sach.donGiaNhap,Sach.soLuong,TheLoai.tenTheLoai,NhaXuatBan.tenNXB,TacGia.tenTacGia,Sach.hinhAnh from Sach"
					+ " inner join NhaCungCap on Sach.maNCC = NhaCungCap.maNCC"
					+ " inner join NhaXuatBan on Sach.maNXB = NhaXuatBan.maNXB"
					+ " inner join TheLoai on Sach.TheLoai = TheLoai.maTheLoai"
					+ " inner join TacGia on Sach.maTacGia = TacGia.maTacGia";
			Statement statement =con.createStatement();
			ResultSet rs=statement.executeQuery(sql);
			
			while(rs.next()) {
				
				String ma = rs.getString(1);
				String hoTen = rs.getString(2);
				
				NhaCungCap tenncc=new NhaCungCap(rs.getString(3));
				double dongia=rs.getDouble(4);
				int soluong=rs.getInt(5);
				TheLoai tl=new TheLoai(rs.getString(6));
				
				
				NhaXuatBan nxb=new NhaXuatBan(rs.getString(7));
				TacGia tacgia=new TacGia(rs.getString(8));
				String hinh=rs.getString(9);
				
				Sach sach=new Sach(ma, hoTen, tenncc, dongia, soluong, tl, nxb, tacgia, hinh);
				dss.add(sach);		
						
							
						
						
						
					
						
				
									
						
						
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dss;
	}
	
public boolean addSach (Sach sach){

	int n = 0 ;
	
	
	try {
		
		Connection con=ConnectDB.getInstance().getConnection();
		//PreparedStatement stmt=null;
		String sql="insert into Sach ([maSach], [tenSach], [maNCC], [donGiaNhap], [soLuong], [TheLoai], [maNXB], [maTacGia], [hinhAnh] )  values(?,?,?,?,?,?,?,?,?)";
		PreparedStatement stmt = con.prepareStatement(sql);
		//stmt =con.prepareStatement("insert into Sach  values(?,?,?,?,?,?,?,?,?)");
		stmt.setString(1, sach.getMaSach());
		stmt.setString(2, sach.getTenSach());
		stmt.setString(3, sach.getNhacungcap().getMaNCC());
		stmt.setDouble(4, sach.getDonGiaNhap());
		stmt.setInt(5, sach.getSoLuong());
		stmt.setString(6, sach.getTheloai().getMaTheLoai());
		stmt.setString(7, sach.getNhaxuatban().getMaNXB());
		stmt.setString(8, sach.getTacgia().getMaTacGia());
		stmt.setString(9, sach.getHinhanh());
		
		
		n = stmt.executeUpdate();
		stmt.close();
		
	} catch (SQLException ex) {
		ex.printStackTrace();
	}finally {
		
	}
	return n>0;
	
}

public boolean updateSach (Sach sach){
	
	
	int n = 0 ;
	try {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		
		String sql = "update Sach set tenSach=?,maNCC =?, donGiaNhap=?,soLuong=?,  TheLoai=?,maNXB=?,maTacGia=?,hinhAnh=? where (maSach=?)" ;
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setString(9, sach.getMaSach());
		stmt.setString(1, sach.getTenSach());
		stmt.setString(2, sach.getNhacungcap().getMaNCC());
		stmt.setDouble(3, sach.getDonGiaNhap());
		stmt.setInt(4, sach.getSoLuong());
		stmt.setString(5, sach.getTheloai().getMaTheLoai());
		stmt.setString(6, sach.getNhaxuatban().getMaNXB());
		stmt.setString(7, sach.getTacgia().getMaTacGia());
		stmt.setString(8, sach.getHinhanh());
		
		
		n = stmt.executeUpdate();
		stmt.close();
		
	} catch (SQLException e) {
		e.printStackTrace();
	} 
	return n > 0 ;

	

}

public boolean xoaSach(int maSach) {
	Connection con = ConnectDB.getInstance().getConnection();
	PreparedStatement stmt = null;
	int n = 0;
	try {
		stmt = con.prepareStatement("DELETE FROM Sach WHERE maSach = ?");
		stmt.setInt(1, maSach);
		n = stmt.executeUpdate();
		
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return n > 0; 
}




//tìm Nhà cung cấp theo SDT

public Sach getKHTheoSDT(String SDT) throws SQLException {
	ConnectDB.getInstance();
	Connection con = ConnectDB.getConnection();
	String sql = "select * from Sach where sdt = '" + SDT + "'";
	try {
		Statement statement = con.createStatement();
		ResultSet rs = statement.executeQuery(sql);
		while (rs.next()) {
			String mas = rs.getString(1);
			String hoTen = rs.getString(2);
			
			NhaCungCap tenncc=new NhaCungCap(rs.getString(3));
			double dongia=rs.getDouble(4);
			int soluong=rs.getInt(5);
			TheLoai tl=new TheLoai(rs.getString(6));
			
			
			NhaXuatBan nxb=new NhaXuatBan(rs.getString(7));
			TacGia tacgia=new TacGia(rs.getString(8));
			String hinh=rs.getString(9);
			
			Sach sach=new Sach(mas, hoTen, tenncc, dongia, soluong, tl, nxb, tacgia, hinh);
			dsSach.add(sach);
			return sach;
			//return ncc;
		}

	} catch (SQLException e) {
		e.printStackTrace();
	}
	return null;
}

// tìm Nhà cung cấp theo tên
public List<Sach> getKHTheoTen(String ten) {
	List<Sach> dsSach = new ArrayList<Sach>();
	ConnectDB.getInstance();
	Connection con = ConnectDB.getConnection();
	String sql = "select * from Sach AS tenSach where tenSach like N'%" + ten + "%'";
	try {
		Statement statement = con.createStatement();
		ResultSet rs = statement.executeQuery(sql);
		while (rs.next()) {
	
			String mas = rs.getString(1);
			String hoTen = rs.getString(2);
			
			NhaCungCap tenncc=new NhaCungCap(rs.getString(3));
			double dongia=rs.getDouble(4);
			int soluong=rs.getInt(5);
			TheLoai tl=new TheLoai(rs.getString(6));
			
			
			NhaXuatBan nxb=new NhaXuatBan(rs.getString(7));
			TacGia tacgia=new TacGia(rs.getString(8));
			String hinh=rs.getString(9);
			
			Sach sach=new Sach(mas, hoTen, tenncc, dongia, soluong, tl, nxb, tacgia, hinh);
			dsSach.add(sach);
			
			

		}

	} catch (SQLException e) {
		e.printStackTrace();
	
}
	return dsSach;
}

// Tìm khách hàng theo mã 
public Sach getKHTheoMa(String ma) {
	ConnectDB.getInstance();
	Connection con = ConnectDB.getConnection();
	String sql = "select * from Sach where maSach = '" + ma + "'";
	try {
		Statement statement = con.createStatement();
		ResultSet rs = statement.executeQuery(sql);
		while (rs.next()) {

			String mas = rs.getString(1);
			String hoTen = rs.getString(2);
			
			NhaCungCap tenncc=new NhaCungCap(rs.getString(3));
			double dongia=rs.getDouble(4);
			int soluong=rs.getInt(5);
			TheLoai tl=new TheLoai(rs.getString(6));
			
			
			NhaXuatBan nxb=new NhaXuatBan(rs.getString(7));
			TacGia tacgia=new TacGia(rs.getString(8));
			String hinh=rs.getString(9);
			
			Sach sach=new Sach(mas, hoTen, tenncc, dongia, soluong, tl, nxb, tacgia, hinh);
			dsSach.add(sach);		
			return sach;
			
		}

	} catch (SQLException e) {
		e.printStackTrace();
	}

	return null;

}


}
