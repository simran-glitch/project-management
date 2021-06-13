<%-- 
    Document   : RegisteredHodList
    Created on : Nov 29, 2020, 5:18:54 PM
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
        <title>View Faculty List</title>
        <link href="RegisteredFacultyList.css" rel="stylesheet" type="text/css"/>
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
            <header id="trisha1">Here The Registered Faculty List</header><br/>
            <tr>
                <th>Faculty Name</th><th>User Name</th><th>Password</th><th>Mobile No</th><th>Department</th>
            </tr>
            <%
                con = OracleConnUtils.getOracleConnection();
                String sql = "select * from FACULTY";
                ps = con.prepareStatement(sql);
                rs = ps.executeQuery();
                while (rs.next()) {
            %>
            <tr>
                
                <td><%=rs.getString(1)%></td>
                <td><%=rs.getString(2)%></td>
                <td><%=rs.getString(3)%></td>
                 <td><%=rs.getLong(4)%></td>
                  <td><%=rs.getString(5)%></td>
                  
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