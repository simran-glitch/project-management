<%-- 
    Document   : RegisteredStudentsList
    Created on : Nov 29, 2020, 3:37:57 PM
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
        <title>View Page</title>
        <link href="RegisteredStudentsList.css" rel="stylesheet" type="text/css"/>
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
            <header id="trisha1">Here The Registered Student List</header><br/>
            <tr>
                <th>Student Name</th><th>User Name</th><th>Mobile No</th><th>Department</th><th>Semester</th><th>Year</th>
            </tr>
            <%
                con = OracleConnUtils.getOracleConnection();
                String sql = "select * from register";
                ps = con.prepareStatement(sql);
                rs = ps.executeQuery();
                while (rs.next()) {
            %>
            <tr>
                
                <td><%=rs.getString(1)%></td>
                <td><%=rs.getString(2)%></td>
                <td><%=rs.getLong(4)%></td>
                 <td><%=rs.getString(5)%></td>
                  <td><%=rs.getInt(6)%></td>
                   <td><%=rs.getInt(7)%></td>
                    
                
            </tr>
            <%
                }
            %>

        </table><br>
        <h4 style="color: red;"><a href="AdminHomePage.jsp">Back to Previous Page</a></h4>
        <h5 style="color: green;"><a href="AdminHomePage.jsp" >Back to Home Page</a></h5>
    </center>
</body>
</html>

}
