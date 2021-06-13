<%@page import="org.o7planning.tutorial.jdbc.OracleConnUtils" %>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="bean.ApprovalProcessDao"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link href="viewFilesF2Style.css" rel="stylesheet" type="text/css"/>
        <title>Downloading Page</title>
       
    </head>
    <body>
        <br><br><br>
    <center>
        <%!
            Connection con = null;
            PreparedStatement ps = null;
            ResultSet rs = null;
        %>
        <table border="2">
            <header id="NUM1">VIEW PROJECT DETAILS</header><br/>
            <tr>
                <th>ID</th><th>Student Name</th><th>File Name</th><th>Description</th><th>Download</th><th>HOD Feedback</th><th>Faculty Feedback</th>
            </tr>
            <%
                con = OracleConnUtils.getOracleConnection();
                String sql = "select * from projects";
                ps = con.prepareStatement(sql);
                rs = ps.executeQuery();
                while (rs.next()) {
            %>
            <tr>
                <td><%=rs.getInt(1)%></td>
                <td><%=rs.getString(2)%></td>
                <td><%=rs.getString(3)%></td>
                <td><%=rs.getString(5)%></td>
                <td><a href="DownloadAttachmentServlet?id=<%=rs.getInt(1)%>">Click Here To Download</a></td>
        
                <td><a href="#">Add Feedback</a></td>
                <td><a href="approvalProcessF.jsp">Add Feedback</a></td>
                
            
 
            </tr>
            <%
                }
            %>

        </table><br>
        
        <h5 style="color: green;"><a href="facultyLoginProcess.jsp" >Back</a></h5>
    </center>
</body>
</html>

}

