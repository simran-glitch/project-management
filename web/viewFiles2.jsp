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
         <link href="viewFilesStyle2.css" rel="stylesheet" type="text/css"/>
        <title>View Page</title>
        
    </head>
    <body>
        <br><br><br>
        <link href="viewFilesStyle2.css" rel="stylesheet" type="text/css"/>
    <center>
        <%!
            Connection con = null;
            PreparedStatement ps = null;
            ResultSet rs = null;
        %>
        <table border="1" cellpadding="5%" width="50%">
            <header id="NUM1" style="font-size: 30px">VIEW PROJECT STATUS</header><br/>
            <tr align="center">
                <th>STUDENT NAME</th><th>PROJECT TITLE</th><th>APPROVAL</th><th>HOD FEEDBACK</th>
            </tr>
            <%
                con = ConnectionProvider.getCon();
                String sql = "select * from approval";
                ps = con.prepareStatement(sql);
                rs = ps.executeQuery();
                while (rs.next()) {
            %>
            <tr align="center">
                <td><%=rs.getString(1)%></td>
                <td><%=rs.getString(2)%></td>
                <td><%=rs.getString(3)%></td>
                <td><%=rs.getString(4)%></td>
                
                
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
