package com.model;

public class Faculty {

	private String faculty_name;
	private String email;
	private long mobile_no;
	private String department;
	private String password;

    @Override
    public String toString() {
        return "Faculty{" + "faculty_name=" + faculty_name + ", email=" + email + ", mobile_no=" + mobile_no + ", department=" + department + ", password=" + password + '}';
    }

    public String getFaculty_name() {
        return faculty_name;
    }

    public void setFaculty_name(String faculty_name) {
        this.faculty_name = faculty_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getMobile_no() {
        return mobile_no;
    }

    public void setMobile_no(long mobile_no) {
        this.mobile_no = mobile_no;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
        

}