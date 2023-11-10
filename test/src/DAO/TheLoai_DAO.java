package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ConnectDB.ConnectDB;
import entity.TheLoai;


public class TheLoai_DAO {
public List<TheLoai> getAllTL(){
		
		List<TheLoai> dsTL=new ArrayList<TheLoai>();
		ConnectDB.getInstance();
		Connection con=ConnectDB.getConnection();
		try {
			String sql="select * from TheLoai";;
			Statement statement =con.createStatement();
			ResultSet rs=statement.executeQuery(sql);
			
			while(rs.next()) {

				dsTL.add(new TheLoai(rs.getString("maTheLoai"),
						rs.getString("tenTheLoai")
						
						
						
			
						
						
						
						));
						
				
									
						
						
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsTL;
	}

public List<TheLoai> gettltheoTen(String ten) {
	List<TheLoai> dsTheLoai = new ArrayList<TheLoai>();
	ConnectDB.getInstance();
	Connection con = ConnectDB.getConnection();
	String sql = "select * from TheLoai AS tenTheLoai where tenTheLoai like N'%" + ten + "%'";
	try {
		Statement statement = con.createStatement();
		ResultSet rs = statement.executeQuery(sql);
		while (rs.next()) {
	
			String maTheLoai = rs.getString(1);
			String tenTheLoai = rs.getString(2);

			TheLoai TL = new TheLoai(maTheLoai, tenTheLoai);
			dsTheLoai.add(TL);
			

		}

	} catch (SQLException e) {
		e.printStackTrace();
	
}
	return dsTheLoai;
}
}
