package com.controller;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Dao.FacultyDao;
import com.model.Faculty;

@WebServlet("/FacultyRegister")
public class FacultyRegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;

        
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		String faculty_name = req.getParameter("fname");
		String email = req.getParameter("uname");
                String password = req.getParameter("pwd");
		String mobile_no = req.getParameter("mbno");
		String department = req.getParameter("dpt");
		
		if (mobile_no  == null || mobile_no.equals("")) {
			mobile_no = "0";
		}
		long mobile = Long.parseLong(mobile_no);
		
                
		
		
		Faculty faculty = new Faculty();
		
		faculty.setFaculty_name(faculty_name);
                faculty.setEmail(email);
                faculty.setPassword(password);
                faculty.setMobile_no(mobile);
                faculty.setDepartment(department);
                
		String result = "";
		FacultyDao dao = new FacultyDao();
		result = dao.insertFaculty(faculty);
		
			
		req.setAttribute("resultKey", result);
		RequestDispatcher rd = req.getRequestDispatcher("RegistrationSuccessfull.jsp");
		rd.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}