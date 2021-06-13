<%@page import="bean.ApprovalProcessDao"%>  
<jsp:useBean id="obj" class="bean.ProcessBean"/>  
  
<jsp:setProperty property="*" name="obj"/>  
  
<%  
boolean status=ApprovalProcessDao.validate(obj);  
if(status){  
    //out.println("SUCCESSFULLY DONE");
session.setAttribute("session","TRUE");  
%>  
<jsp:include page="approvalProcess3.jsp"></jsp:include>  
<% 
}  
else  
{  
out.print("Sorry, there is an error");  
%>  
<jsp:include page="approvalProcess.jsp"></jsp:include>  
<%  
}  
%>