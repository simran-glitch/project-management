package org.o7planning.servletexamples.model;

import java.sql.Blob;


/**
 *
 * @author dell
 */
public class Attachment {
    private  int Id;
    private String studentName;
    private String fileName;
    private Blob fileData; 
    private String Description;

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Blob getFileData() {
        return fileData;
    }

    public void setFileData(Blob fileData) {
        this.fileData = fileData;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public Attachment(int Id, String studentName, String fileName, Blob fileData, String Description) {
        this.Id = Id;
        this.studentName = studentName;
        this.fileName = fileName;
        this.fileData = fileData;
        this.Description = Description;
    }

}