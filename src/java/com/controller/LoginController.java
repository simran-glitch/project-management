
package com.controller;

import com.Dao.StudentDao;
import com.model.Student;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Login")
public class LoginController extends HttpServlet {
   
         
      protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
          String userName = req.getParameter("uname");
          String password = req.getParameter("pass");
          
          String result= null;
          String pageName= "";
          Student student= new Student();
          student.setEmail(userName);
          student.setPassword(password);
          boolean isUserValid = new StudentDao().validateUser(student);
          if (isUserValid){
             
              pageName = "StudentHomePage.html";
              req.setAttribute("studentkey", student);
              
          }else{
              pageName = "InvalidUserIDorPassword2.jsp";
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
