<%-- 
    Document   : viewFiles
    Created on : Nov 24, 2020, 4:54:56 PM
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
        <link href="RegisteredStudentsList.css" rel="stylesheet" type="text/css"/>
        <title>View Page</title>

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
            <header id="Trisha1">Your File is Uploaded Here</header><br/>
            <tr>
                <th>ID</th><th>Student Name</th><th>File Name</th><th>Description</th>
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
                
            </tr>
            <%
                }
            %>

        </table><br>
        <h4 style="color: red;"><a href="uploadToDB.jsp">Back to file uploading page</a></h4>
        <h5 style="color: green;"><a href="index.jsp" >Back to Home Page</a></h5>
    </center>
</body>
</html>

}

