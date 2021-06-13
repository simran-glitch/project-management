<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@page import="bean.FacultyLoginDao"%>  
<jsp:useBean id="obj" class="bean.LoginBean"/>  
  
<jsp:setProperty property="*" name="obj"/>  
  
<%  
boolean status=FacultyLoginDao.validate(obj);  
if(status){ 
    %>  
<jsp:include page="facultyLoginProcess2.jsp"></jsp:include>  
<% 



session.setAttribute("session","TRUE");  
}  
else  
{  
out.print("Sorry, username or password error");  
%>  
<jsp:include page="facultyLogin.jsp"></jsp:include>  
<%  
}  
%>  



