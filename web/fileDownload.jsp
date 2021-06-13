<%-- 
    Document   : fileDownload
    Created on : Nov 24, 2020, 4:38:58 PM
    Author     : dell
--%>
<%@page import="org.o7planning.tutorial.jdbc.OracleConnUtils" %>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Downloading Page</title>
        <link href="fileDownloadStyle.css" rel="stylesheet" type="text/css"/>
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
            <header id="Trisha1"> VIEW PROJECT DETAILS</header><br/>
            <tr>
                <th>ID</th><th>STUDENT NAME</th><th>File Name</th><th>Description</th><th>Download</th><th>HOD FEEDBACK</th><th>FACULTY FEEDBACK</th>
                
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
                <td><a href="approvalProcess2.jsp">Add FEEDBACK </a></td>
                <td><a href="#">Add FEEDBACK </a></td>
            </tr>
            <%
                }
            %>

        </table><br>
        <h4 style="color: red; font-size: 20px;"><a href="HOME.jsp">LOGOUT</a></h4>
        <h5 style="color: green; font-size: 20px;"><a href="HodLoginProcess2.jsp" >BACK</a></h5>
    </center>
</body>
</html>

}

