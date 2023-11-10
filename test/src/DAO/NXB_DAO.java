package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ConnectDB.ConnectDB;
import entity.KhachHang;
import entity.NhaXuatBan;
import entity.TheLoai;

public class NXB_DAO {

public List<NhaXuatBan> getAllNXB(){
		
		List<NhaXuatBan> dsnxb=new ArrayList<NhaXuatBan>();
		ConnectDB.getInstance();
		Connection con=ConnectDB.getConnection();
		try {
			String sql="select * from NhaXuatBan";;
			Statement statement =con.createStatement();
			ResultSet rs=statement.executeQuery(sql);
			
			while(rs.next()) {

				dsnxb.add(new NhaXuatBan(rs.getString("maNXB"),
						rs.getString("tenNXB"),
						
						
						rs.getString("diaChi")
						
						
				
						
						));
						
				
									
						
						
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsnxb;
	}

public List<NhaXuatBan> getNXBtheoTen(String ten) {
	List<NhaXuatBan> dsNXB = new ArrayList<NhaXuatBan>();
	ConnectDB.getInstance();
	Connection con = ConnectDB.getConnection();
	String sql = "select * from NhaXuatBan AS tenNXB where tenNXB like N'%" + ten + "%'";
	try {
		Statement statement = con.createStatement();
		ResultSet rs = statement.executeQuery(sql);
		while (rs.next()) {
	
			String maNXB = rs.getString(1);
			String tenNXB = rs.getString(2);
			String diaChi = rs.getString(3);
			NhaXuatBan nxb = new NhaXuatBan(maNXB, tenNXB, diaChi);
			dsNXB.add(nxb);
			

		}

	} catch (SQLException e) {
		e.printStackTrace();
	
}
	return dsNXB;
}

}
