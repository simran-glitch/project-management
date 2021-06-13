
package com.controller;

import com.Dao.HodDao;
import com.model.Hod;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/HodLogin")
public class HodLoginController extends HttpServlet {
   
         
      protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
          String userName = req.getParameter("name");
          String password = req.getParameter("pwd");
          
          String result= null;
          String pageName= "";
          Hod hod= new Hod();
          hod.setEmail(userName);
          hod.setPassword(password);
          boolean isUserValid = new HodDao().validateUser(hod);
          if (isUserValid){
             
              pageName = "HodLoginProcess2.jsp";
              req.setAttribute("hodkey", hod);
              
          }else{
              pageName = "InvalidUserIDorPassword.jsp" ;
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
