<%-- 
    Document   : approvalProcess
    Created on : Nov 29, 2020, 6:30:03 PM
    Author     : dell
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="approvalProcess.css" rel="stylesheet">
        <title>approval Page</title>
    </head>
    <body style="background: url(https://www.drumangle.com/sandbox/wp/21813/wp-content/uploads/2014/01/Login-Screen-Background-Wood-5.jpg); background-size: cover;">
        <p> ADD FEEDBACK </p>
        <form action="fileDownload.jsp" method="post">
         <div align="center">
            <input id="tab1" type="submit" class="button" value="BACK"/>
        </div>
        </form>
        </br> <div class="box" align="center" style="margin-top:15%; padding:5px; color:black; font-size: 20px" >
            
            <div class="login-form">
                 <form align="center" method="post" action="approvalProcess2.jsp">
            <div>
                <br>  <label for="studentname">STUDENT NAME</label>
                <input id="ID1" type="text" class="input" name="studentname" required />
            </div>
            <div>
                <br> <label for="projecttitle">PROJECT TITLE</label>
                 <input id="tanya2" type="text" name="projecttitle"  required />
            </div>
            <div>
                <br>  <label for="approval">APPROVAL</label>
                <input id="tanya3" type="text" class="input" name="approval" required />
            </div>
            <div>
                <br> <label for="description"> HOD FEEDBACK</label>
                <br> <input id="tanya4" type="text" name="description" size="50" required />
            </div>
                     
                     
            <div>
               <br> <input id="tanya5" type="submit" class="button" value="SUBMIT" />
             </div>
                 </form>
            </div>
            
        </div>
          
    </body>
</html>
