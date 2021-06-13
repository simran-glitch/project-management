<%@page import="bean.HodLoginDao"%>  
<jsp:useBean id="obj" class="bean.LoginBean"/>  
  
<jsp:setProperty property="*" name="obj"/>  
  
<%  
boolean status=HodLoginDao.validate(obj);  
if(status){  
//out.println("You r successfully logged in");  
%>
<jsp:include page="HodLoginProcess2.jsp"></jsp:include>
<%
session.setAttribute("session","TRUE");
}  
else  
{  
out.print("Sorry, username or password error");  
%>  
<jsp:include page="HodLogin.jsp"></jsp:include>  
<%  
}  
%>  