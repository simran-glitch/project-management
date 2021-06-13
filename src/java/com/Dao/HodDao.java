
package com.Dao;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.model.Hod;

public class HodDao extends GenericDao {

	public HodDao() {
		getConnection();
	}

	public String insertHod(Hod hod) {
		String sql = "insert into HOD(HOD_NAME, USERNAME, PASSWORD, MOBILE_NUMBER, DEPARTMENT) values(?, ?, ?, ?, ?)";
		String result = "";
		PreparedStatement ps = null;
		try {
			System.out.println(con);
			ps = con.prepareStatement(sql);
			int parameterIndex = 0;
			
			ps.setString(++parameterIndex, hod.getHod_name());
			ps.setString(++parameterIndex, hod.getEmail());
                        ps.setString(++parameterIndex, hod.getPassword());
			ps.setLong(++parameterIndex, hod.getMobile_no());
			ps.setString(++parameterIndex, hod.getDepartment());
			
			int i = ps.executeUpdate();
			if (i != 0) {
				result = "Record has been inserted";
			} else {
				result = "Failed to insert the data";
			}
		} catch (SQLException e) {
			result = "Failed to insert due to error";
			e.printStackTrace();
		} finally {
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		System.out.println(result);
		System.out.println("---------------------------------------------------");
		return result;
	}

	public boolean validateUser(Hod hod) {
		String sql = "select * from HOD where USERNAME = ? and PASSWORD = ?";
		try {
			System.out.println(con);
			PreparedStatement ps = con.prepareStatement(sql);
			int parameterIndex = 0;
			ps.setString(++parameterIndex, hod.getEmail());
			ps.setString(++parameterIndex, hod.getPassword());
			ResultSet rs = ps.executeQuery();
			if (rs != null) {
				if (rs.next()) {
					System.out.println("Hod featched");
					return true;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	
}


