
package com.Dao;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.model.Faculty;

public class FacultyDao extends GenericDao {

	public FacultyDao() {
		getConnection();
	}

	public String insertFaculty(Faculty faculty) {
		String sql = "insert into FACULTY(FACULTY_NAME, USERNAME, PASSWORD, MOBILE_NUMBER, DEPARTMENT) values(?, ?, ?, ?, ?)";
		String result = "";
		PreparedStatement ps = null;
		try {
			System.out.println(con);
			ps = con.prepareStatement(sql);
			int parameterIndex = 0;
			
			ps.setString(++parameterIndex, faculty.getFaculty_name());
			ps.setString(++parameterIndex, faculty.getEmail());
                        ps.setString(++parameterIndex, faculty.getPassword());
			ps.setLong(++parameterIndex, faculty.getMobile_no());
			ps.setString(++parameterIndex, faculty.getDepartment());
			
			
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

	public boolean validateUser(Faculty faculty) {
		String sql = "select * from FACULTY where USERNAME = ? and PASSWORD = ?";
		try {
			System.out.println(con);
			PreparedStatement ps = con.prepareStatement(sql);
			int parameterIndex = 0;
			ps.setString(++parameterIndex, faculty.getEmail());
			ps.setString(++parameterIndex, faculty.getPassword());
			ResultSet rs = ps.executeQuery();
			if (rs != null) {
				if (rs.next()) {
					System.out.println("Faculty featched");
					return true;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	
}


