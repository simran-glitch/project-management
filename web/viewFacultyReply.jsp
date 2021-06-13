<%-- 
    Document   : viewFacultyReply
    Created on : Nov 30, 2020, 5:09:02 PM
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
        <title>View Faculty Reply Page</title>
        <link href="viewFacultyReplyStyle.css" rel="stylesheet" type="text/css"/>

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
            <header style="font-weight: bolder">Your Faculty is Replied Here</header><br/>
            <tr>
                <th>Student Name</th><th>Project Title</th><th>Feedback</th>
            </tr>
            <%
                con = OracleConnUtils.getOracleConnection();
                String sql = "select * from Project";
                ps = con.prepareStatement(sql);
                rs = ps.executeQuery();
                while (rs.next()) {
            %>
            <tr>
                <td><%=rs.getString(1)%></td>
                <td><%=rs.getString(2)%></td>
                <td><%=rs.getString(3)%></td>
                
                
            </tr>
            <%
                }
            %>

        </table><br>
        <h4 style="color: red;"><a href="uploadToDB.jsp">Back to file uploading page</a></h4>
        <h5 style="color: green;"><a href="StudentHomePage.html" >Back to Home Page</a></h5>
    </center>
</body>
</html>

}
