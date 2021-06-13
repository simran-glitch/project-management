package bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Tanya Agarwal
 */
public class ApprovalProcessDao {
 public static boolean validate(ProcessBean bean){  
boolean status=false;  
try{  
Connection con=ConnectionProvider.getCon();  
    
   String sql= "insert into approval (studentname,projecttitle,approval,description) values(?,?,?,?)";  
  PreparedStatement ps=con.prepareStatement(sql);

ps.setString(1,bean.getStudentname());
ps.setString(2,bean.getProjecttitle());
  ps.setString(3,bean.getApproval());
ps.setString(4,bean.getDescription());

              
ResultSet rs=ps.executeQuery();  
status=rs.next();  
              
}catch(Exception e){}  
  
return status;  
  
}     
}
