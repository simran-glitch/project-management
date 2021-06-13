<%-- 
    Document   : HodRegistration
    Created on : Nov 29, 2020, 3:29:00 PM
    Author     : dell
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Hod Registration Page</title>
        <link href="HodRegistrationStyle.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        
          <h4><a href="AdminHomePage.jsp" style="text-decoration: none;color: red">Click Here</a> to Back</h4>
        <form action="HodRegister" method="POST">
           
            <div id="subhankar">
                <p><u>HOD Registration Section</u></p>
                <h3>HOD Name: <input id="trisha1" type="text" placeholder="Enter Your Full Name" name="hname" required="" /></h3>
                <h3>User Name: <input id="trisha2" type="text" placeholder="Enter Your Email Id" name="uname" required="" /></h3>
                <h3>Password: <input id="trisha3" type="password" placeholder="Enter Your Password" name="pwd" required="" /></h3>
                <h3>Mobile Number: <input id="trisha4" type="number" placeholder="Enter Your Valid Mobile No" name="mbno" required="" /></h3>
                <h3>Department: <input id="trisha5" type="text" placeholder="Enter Your Department" name="dpt" required="" /></h3>
                <h5 style="color:white"> <input id="trisha8" type="checkbox" checked="checked" name="remember" /> Remember me<input id="trisha9" type="submit" value="Register"/></h5>
               
            </div>
        </form>
        
    </body>
</html>
