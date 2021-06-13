package com.Dao;

import java.sql.Connection;
import java.sql.SQLException;

import com.util.ConnectionUtils;

public abstract class GenericDao {
	public Connection con;
	public void getConnection() {
		con = ConnectionUtils.getConnection("jdbc:oracle:thin:@//DESKTOP-E1PCJU5:1521/XE","javabatch","myscholars");
	}
 
	public void closeConnection() {
		if (con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
