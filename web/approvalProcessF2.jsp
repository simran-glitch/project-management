<%@page import="bean.ApprovalProcessFDao"%>  
<jsp:useBean id="obj" class="bean.ProcessBeanF"/>  
  
<jsp:setProperty property="*" name="obj"/>  
  
<%  
boolean status=ApprovalProcessFDao.validate(obj);  
if(status){   
session.setAttribute("session","TRUE"); 
 %>  
<jsp:include page="approvalProcessF3.jsp"></jsp:include>  
<% 

}  
else  
{  
out.print("Sorry, there is an error");  
%>  
<jsp:include page="approvalProcessF.jsp"></jsp:include>  
<%  
}  
%>
