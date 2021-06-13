package com.controller;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Dao.StudentDao;
import com.model.Student;

@WebServlet("/Register")
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;

        
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		String student_name = req.getParameter("stuname");
		String email = req.getParameter("uname");
                String password = req.getParameter("pwd");
		String mobile_no = req.getParameter("mbno");
		String department = req.getParameter("dpt");
		String semesterStr= req.getParameter("sem");
		String yearStr = req.getParameter("year");
		

		if (mobile_no  == null || mobile_no.equals("")) {
			mobile_no = "0";
		}
		long mobile = Long.parseLong(mobile_no);
		
                if (semesterStr == null || semesterStr.equals("")) {
			semesterStr = "0";
		}
		int semester = Integer.parseInt(semesterStr);
		
                if (yearStr == null || yearStr.equals("")) {
			yearStr = "0";
		}
		int year = Integer.parseInt(yearStr);
		
		
		Student student = new Student();
		
		student.setStudent_name(student_name);
                student.setEmail(email);
                student.setPassword(password);
                student.setMobile_no(mobile);
                student.setDepartment(department);
                student.setSemester(semester);
                student.setYear(year);

		String result = "";
		StudentDao dao = new StudentDao();
		result = dao.insertStudent(student);
		
			
		req.setAttribute("resultKey", result);
		RequestDispatcher rd = req.getRequestDispatcher("Login.html");
		rd.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}