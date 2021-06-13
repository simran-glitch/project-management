<%-- 
    Document   : HodLogin
    Created on : Nov 29, 2020, 10:23:52 PM
    Author     : dell
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <title>Login Page</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="hodLoginStyle.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
   <div class="login-wrap">
	<div class="login-html">
		<input id="tab-1" type="radio" name="tab" class="sign-in" checked><label for="tab-1" class="tab">HOD LOGIN</label>
    
		<div class="login-form">
			<div class="sign-in-htm">
                            <form action="HodLogin" method="post">
				<div class="group">
					<label for="uname" class="label">Username</label>
					<input id="uname" type="text" class="input" name="name" required>
				</div>
				<div class="group">
					<label for="pass" class="label">Password</label>
					<input id="pass" type="password" class="input" name="pwd" required>
				</div>
                              <div class="group">
                                  </br> </br> </br> </br>  <input type="submit" class="button" value="Sign In">
				</div>
                             </form>
                            <form method="post" action="index.jsp">
                                
                                   <div class="group">
                                 <input type="submit" class="button" value="BACK TO HOME PAGE">
				</div>
                                 </form>
                              
                </div>
        </div>
   </div>
</body>
</html>
