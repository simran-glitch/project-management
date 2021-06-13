
package org.o7planning.servletexamples;


import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
 
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.o7planning.servletexamples.model.Attachment;
import org.o7planning.tutorial.jdbc.OracleConnUtils;

@WebServlet("/downloadAttachment")
public class DownloadAttachmentServlet extends HttpServlet {
   private static final int serialVersionUID = 1;
 
 
   @Override
   protected void doGet(HttpServletRequest request, HttpServletResponse response)
           throws ServletException, IOException {
       Connection conn = null;
       try {
           // Get Database Connection.
           // (See more in JDBC Tutorial).
           conn = OracleConnUtils.getOracleConnection();
           int id = 1;
           try {
               id = Integer.parseInt(request.getParameter("id"));
           } catch (Exception e) {
 
           }
           Attachment attachment = getAttachmentFromDB(conn,id);
 
           if (attachment == null) {
               // No record found.
               response.getWriter().write("No data found");
               return;
           }
            String studentName = attachment.getStudentName();
            System.out.println("Student Name: " + studentName);
           // file1.zip, file2.zip
           String fileName = attachment.getFileName();
           System.out.println("File Name: " + fileName);
 
           // abc.txt => text/plain
           // abc.zip => application/zip
           // abc.pdf => application/pdf
           String contentType = this.getServletContext().getMimeType(fileName);
           System.out.println("Content Type: " + contentType);
 
           response.setHeader("Content-Type", contentType);
 
           response.setHeader("Content-Length", String.valueOf(attachment.getFileData().length()));
 
           response.setHeader("Content-Disposition", "inline; filename=\"" + attachment.getFileName() + "\"");
 
           // For big BLOB data.
           Blob fileData = attachment.getFileData();
           InputStream is = fileData.getBinaryStream();
 
           byte[] bytes = new byte[1024];
           int bytesRead;
 
           while ((bytesRead = is.read(bytes)) != -1) {
               // Write image data to Response.
               response.getOutputStream().write(bytes, 0, bytesRead);
           }
           is.close();
 
       } catch (Exception e) {
           throw new ServletException(e);
       } finally {
           this.closeQuietly(conn);
       }
   }
 
   private Attachment getAttachmentFromDB(Connection conn, int id) throws SQLException {
       String sql = "Select a.Id,a.Student_Name,a.File_Name,a.File_Data,a.Description "//
               + " from Projects a where a.id = ?";
       PreparedStatement pstm = conn.prepareStatement(sql);
       pstm.setInt(1,id);
       ResultSet rs = pstm.executeQuery();
       if (rs.next()) {
           String studentName = rs.getString("Student_Name");
           String fileName = rs.getString("File_Name");
           Blob fileData = rs.getBlob("File_Data");
           String description = rs.getString("Description");
           return new Attachment( id ,studentName,fileName,fileData,description);
       }
       return null;
   }
 
   private void closeQuietly(Connection conn) {
       try {
           if (conn != null) {
               conn.close();
           }
       } catch (Exception e) {
       }
   }
 
}