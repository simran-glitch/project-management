<%@page import="bean.Provider" %>
<%@page import="bean.ConnectionProvider" %>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="viewFilesF2Style.css" rel="stylesheet">
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
        <table border="1" cellpadding="5%" width="50%">
            <header id="NUM1" style="font-size: 30px">VIEW PROJECT STATUS</header><br/>
            <tr align="center">
                <th>STUDENT NAME</th><th>PROJECT TITLE</th><th>FACULTY FEEDBACK</th>
            </tr>
            <%
                con = ConnectionProvider.getCon();
                String sql = "select * from project";
                ps = con.prepareStatement(sql);
                rs = ps.executeQuery();
                while (rs.next()) {
            %>
            <tr align="center">
                <td><%=rs.getString(1)%></td>
                <td><%=rs.getString(2)%></td>
                <td><%=rs.getString(3)%></td>
                
                
            </tr>
            <%
                }
            %>

        </table><br>
        
    </center>
</body>
</html>

}

