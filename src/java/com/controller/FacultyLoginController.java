
package com.controller;

import com.Dao.FacultyDao;
import com.model.Faculty;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/FacultyLogin")
public class FacultyLoginController extends HttpServlet {
   
         
      protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
          String userName = req.getParameter("uname");
          String password = req.getParameter("pass");
          
          String result= null;
          String pageName= "";
          Faculty faculty= new Faculty();
          faculty.setEmail(userName);
          faculty.setPassword(password);
          boolean isUserValid = new FacultyDao().validateUser(faculty);
          if (isUserValid){
             
              pageName = "facultyLoginProcess2.jsp";
              req.setAttribute("facultykey", faculty);
              
          }else{
              pageName = "InvalidUserIdorPassword1.jsp";
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
