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


import java.util.Date;


public class KhachHang_DAO {
	
	ArrayList<entity.KhachHang> dskh;
	public KhachHang_DAO() {
		dskh = new ArrayList<KhachHang>();

	}	
public List<KhachHang> getAllKH(){
		
		List<KhachHang> dsKH=new ArrayList<KhachHang>();
		ConnectDB.getInstance();
		Connection con=ConnectDB.getConnection();
		try {
			String sql="select * from KhachHang";;
			Statement statement =con.createStatement();
			ResultSet rs=statement.executeQuery(sql);
			
			while(rs.next()) {

				dsKH.add(new KhachHang(rs.getString("maKH"),
						rs.getString("tenKH"),
						rs.getDate("ngaySinh"),
						
						rs.getString("diaChi"),
						rs.getString("sdt")
						//rs.getFloat("uuDai")
						
						
						));
						
				
									
						
						
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsKH;
	}


public void addKH(KhachHang khach) {
	Connection con = ConnectDB.getInstance().getConnection();
    PreparedStatement stmt = null;
   
    try {
        stmt = con.prepareStatement("insert into KhachHang values(?,?,?,?,?)");
        stmt.setString(1, khach.getMaKH());
        stmt.setString(2, khach.getTenKH());
        // Chuyển đổi ngày tháng từ java.util.Date thành java.sql.Date
        java.sql.Date sqlDate = new java.sql.Date(khach.getNgaySinh().getTime());

        stmt.setDate(3, sqlDate); // Sử dụng java.sql.Date đã chuyển đổi
        stmt.setString(4, khach.getDiaChi());
        stmt.setString(5, khach.getSdt());
        //stmt.setFloat(6, khach.getUuDai());
        stmt.executeUpdate();
    } catch (SQLException ex) {
        ex.printStackTrace();
	}finally {
		Close(stmt);
	}
}



public void updateKH(KhachHang khach) {
	Connection con=ConnectDB.getInstance().getConnection();
		PreparedStatement stmt=null;
	String sql = "UPDATE KhachHang "
            + "SET tenKH = ?,"
            + "ngaySinh = ?,"
            + "diaChi = ?,"
            + "sdt = ?,"
            //+ "uuDai = ?"
            + "WHERE maKH = ?";
	try {
		stmt =con.prepareStatement(sql);
		
        stmt.setString(1, khach.getTenKH());
        // Chuyển đổi ngày tháng từ java.util.Date thành java.sql.Date
        java.sql.Date sqlDate = new java.sql.Date(khach.getNgaySinh().getTime());

        stmt.setDate(2, sqlDate); // Sử dụng java.sql.Date đã chuyển đổi
        stmt.setString(3, khach.getDiaChi());
        stmt.setString(4, khach.getSdt());
        //stmt.setFloat(5, khach.getUuDai());
        stmt.setString(6, khach.getMaKH());
        stmt.executeUpdate();
		
	} catch (SQLException ex) {
		ex.printStackTrace();
	}finally {
		Close(stmt);
	}
}

private void Close(PreparedStatement stmt) {
	if(stmt !=null)
		try {
			stmt.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	
}

//tìm Nhà cung cấp theo SDT

			public KhachHang getKHTheoSDT(String SDT) throws SQLException {
				ConnectDB.getInstance();
				Connection con = ConnectDB.getConnection();
				String sql = "select * from KhachHang where sdt = '" + SDT + "'";
				try {
					Statement statement = con.createStatement();
					ResultSet rs = statement.executeQuery(sql);
					while (rs.next()) {
						String makh = rs.getString(1);
						String tenkh = rs.getString(2);
						java.sql.Date ngaySinh=rs.getDate(3);
						String diaChi = rs.getString(4);
						String Sdt = rs.getString(5);
						KhachHang kh=new KhachHang(makh, tenkh, ngaySinh, diaChi, Sdt);
						//NhaCungCap ncc = new NhaCungCap(maNCC, tenNCC, Sdt, diaChi, tinhTrang);
						//dsncc.add(ncc);
						dskh.add(kh);
						return kh;
						//return ncc;
					}

				} catch (SQLException e) {
					e.printStackTrace();
				}
				return null;
			}
			
			// tìm Nhà cung cấp theo tên
			public List<KhachHang> getKHTheoTen(String ten) {
				List<KhachHang> dskh = new ArrayList<KhachHang>();
				ConnectDB.getInstance();
				Connection con = ConnectDB.getConnection();
				String sql = "select * from KhachHang AS tenKH where tenKH like N'%" + ten + "%'";
				try {
					Statement statement = con.createStatement();
					ResultSet rs = statement.executeQuery(sql);
					while (rs.next()) {
				
						String makh = rs.getString(1);
						String tenkh = rs.getString(2);
						java.sql.Date ngaySinh=rs.getDate(3);
						String diaChi = rs.getString(4);
						String Sdt = rs.getString(5);
						KhachHang kh=new KhachHang(makh, tenkh, ngaySinh, diaChi, Sdt);
						//NhaCungCap ncc = new NhaCungCap(maNCC, tenNCC, Sdt, diaChi, tinhTrang);
						//dsncc.add(ncc);
						dskh.add(kh);
						
						//return ncc;
						
						

					}

				} catch (SQLException e) {
					e.printStackTrace();
				
			}
				return dskh;
			}
			
			// Tìm khách hàng theo mã 
			public KhachHang getKHTheoMa(String ma) {
				ConnectDB.getInstance();
				Connection con = ConnectDB.getConnection();
				String sql = "select * from KhachHang where maKH = '" + ma + "'";
				try {
					Statement statement = con.createStatement();
					ResultSet rs = statement.executeQuery(sql);
					while (rs.next()) {
						String makh = rs.getString(1);
						String tenkh = rs.getString(2);
						java.sql.Date ngaySinh=rs.getDate(3);
						String diaChi = rs.getString(4);
						String Sdt = rs.getString(5);
						KhachHang kh=new KhachHang(makh, tenkh, ngaySinh, diaChi, Sdt);
						//NhaCungCap ncc = new NhaCungCap(maNCC, tenNCC, Sdt, diaChi, tinhTrang);
						//dsncc.add(ncc);
						dskh.add(kh);
						return kh;
						//return ncc;
					}

				} catch (SQLException e) {
					e.printStackTrace();
				}

				return null;

			}
	
			
			
	

}
