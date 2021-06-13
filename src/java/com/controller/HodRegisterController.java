package com.controller;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Dao.HodDao;
import com.model.Hod;

@WebServlet("/HodRegister")
public class HodRegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;

        
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		String hod_name = req.getParameter("hname");
		String email = req.getParameter("uname");
                String password = req.getParameter("pwd");
		String mobile_no = req.getParameter("mbno");
		String department = req.getParameter("dpt");
		
		

		if (mobile_no  == null || mobile_no.equals("")) {
			mobile_no = "0";
		}
		long mobile = Long.parseLong(mobile_no);
		
                
		
		Hod hod = new Hod();
		
		hod.setHod_name(hod_name);
                hod.setEmail(email);
                hod.setPassword(password);
               hod.setMobile_no(mobile);
               hod.setDepartment(department);
                
		String result = "";
		HodDao dao = new HodDao();
		result = dao.insertHod(hod);
		
			
		req.setAttribute("resultKey", result);
		RequestDispatcher rd = req.getRequestDispatcher("RegistrationSuccessfull.jsp");
		rd.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}