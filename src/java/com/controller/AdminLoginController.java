
package com.controller;

import com.Dao.AdminDao;
import com.model.Admin;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/AdminLogin")
public class AdminLoginController extends HttpServlet {
   
         
      protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
          String userName = req.getParameter("email");
          String password = req.getParameter("pass");
          
          String result= null;
          String pageName= "";
         Admin admin= new Admin();
         admin.setUsername(userName);
         admin.setPassword(password);
          boolean isUserValid = new AdminDao().validateUser(admin);
          if (isUserValid){
             
              pageName = "AdminHomePage.jsp";
              req.setAttribute("adminkey", admin);
              
          }else{
              pageName = "invalidUserIDorPassword4.jsp";
              result = "Invalid Username & Password...";
          }
          req.setAttribute("resultkey",result);
          RequestDispatcher rd = req.getRequestDispatcher(pageName);
          rd.forward(req, resp);
      }
      
      @Override
      protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        doGet(req, resp);
      }
    
}
