package bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Tanya Agarwal
 */
public class ApprovalProcessFDao {
 public static boolean validate(ProcessBeanF bean){  
boolean status=false;  
try{  
Connection con=ConnectionProvider.getCon();  
    
   String sql= "insert into project(studentname,projecttitle,ffeedback) values(?,?,?)";  
  PreparedStatement ps=con.prepareStatement(sql);

ps.setString(1,bean.getStudentname());
ps.setString(2,bean.getProjecttitle());
ps.setString(3,bean.getFfeedback());

              
ResultSet rs=ps.executeQuery();  
status=rs.next();  
              
}catch(Exception e){}  
  
return status;  
  
}     
}
