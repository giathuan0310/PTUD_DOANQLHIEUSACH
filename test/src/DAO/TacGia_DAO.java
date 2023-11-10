package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ConnectDB.ConnectDB;
import entity.NhaXuatBan;
import entity.TacGia;


public class TacGia_DAO {
public List<TacGia> getAllTG(){
		
		List<TacGia> dsTG=new ArrayList<TacGia>();
		ConnectDB.getInstance();
		Connection con=ConnectDB.getConnection();
		try {
			String sql="select * from TacGia";;
			Statement statement =con.createStatement();
			ResultSet rs=statement.executeQuery(sql);
			
			while(rs.next()) {

				dsTG.add(new TacGia(rs.getString("maTacGia"),
						rs.getString("tenTacGia")
						
						
						
						
						
						
						
						));
						
				
									
						
						
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsTG;
	}

public List<TacGia> getTGtheoTen(String ten) {
	List<TacGia> dstg = new ArrayList<TacGia>();
	ConnectDB.getInstance();
	Connection con = ConnectDB.getConnection();
	String sql = "select * from TacGia AS tenTacGia where tenTacGia like N'%" + ten + "%'";
	try {
		Statement statement = con.createStatement();
		ResultSet rs = statement.executeQuery(sql);
		while (rs.next()) {
	
			String maTacGia = rs.getString(1);
			String tenTacGia = rs.getString(2);
			
			TacGia tg = new TacGia(maTacGia, tenTacGia);
			dstg.add(tg);
			

		}

	} catch (SQLException e) {
		e.printStackTrace();
	
}
	return dstg;
}
}
