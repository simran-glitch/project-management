

package com.Dao;

import com.model.Admin;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminDao extends GenericDao {

    public AdminDao() {
        getConnection();
    }
    
   
    	public boolean validateUser(Admin admin) {
		String sql = "select * from Admin where USERNAME = ? and PASSWORD = ?";
		try {
			System.out.println(con);
			PreparedStatement ps = con.prepareStatement(sql);
			int parameterIndex = 0;
			ps.setString(++parameterIndex, admin.getUsername());
			ps.setString(++parameterIndex, admin.getPassword());
			ResultSet rs = ps.executeQuery();
			if (rs != null) {
				if (rs.next()) {
					System.out.println("Admin featched");
					return true;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

    
    
}