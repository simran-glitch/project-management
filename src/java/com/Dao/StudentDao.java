package com.Dao;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.model.Student;

public class StudentDao extends GenericDao {

	public StudentDao() {
		getConnection();
	}

	public String insertStudent(Student student) {
		String sql = "insert into register(STUDENT_NAME, USER_NAME, PASSWORD, MOBILE_NO, DEPARTMENT, SEMESTER,YEAR) values(?, ?, ?, ?, ?, ?, ?)";
		String result = "";
		PreparedStatement ps = null;
		try {
			System.out.println(con);
			ps = con.prepareStatement(sql);
			int parameterIndex = 0;
			
			ps.setString(++parameterIndex, student.getStudent_name());
			ps.setString(++parameterIndex, student.getEmail());
                        ps.setString(++parameterIndex, student.getPassword());
			ps.setLong(++parameterIndex, student.getMobile_no());
			ps.setString(++parameterIndex, student.getDepartment());
			ps.setInt(++parameterIndex, student.getSemester());
			ps.setInt(++parameterIndex, student.getYear());
			
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

	public boolean validateUser(Student student) {
		String sql = "select * from register where USER_NAME = ? and PASSWORD = ?";
		try {
			System.out.println(con);
			PreparedStatement ps = con.prepareStatement(sql);
			int parameterIndex = 0;
			ps.setString(++parameterIndex, student.getEmail());
			ps.setString(++parameterIndex, student.getPassword());
			ResultSet rs = ps.executeQuery();
			if (rs != null) {
				if (rs.next()) {
					System.out.println("Student featched");
					return true;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	
}

