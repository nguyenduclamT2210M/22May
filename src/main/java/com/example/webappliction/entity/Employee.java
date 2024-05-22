package com.example.webappliction.entity;

import java.util.Date;

public class Employee {
    private int id;
    private String fullname;
    private Date birthday;
    private String address;
    private String position;
    private String department;
    private String cmnd;

    public Employee(int id,String cmnd, String fullname, Date birthday, String address, String position, String department) {
        this.id = id;
        this.cmnd = cmnd;
        this.fullname = fullname;
        this.birthday = birthday;
        this.address = address;
        this.position = position;
        this.department = department;

    }public Employee(String cmnd, String fullname, Date birthday, String address, String position, String department) {
        this.id = id;
        this.cmnd = cmnd;
        this.fullname = fullname;
        this.birthday = birthday;
        this.address = address;
        this.position = position;
        this.department = department;

    }
    public Employee(){}
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public java.sql.Date getBirthday() {
        return (java.sql.Date) birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getCmnd() {
        return cmnd;
    }

    public void setCmnd(String cmnd) {
        this.cmnd = cmnd;
    }
}
