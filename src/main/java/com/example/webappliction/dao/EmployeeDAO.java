package com.example.webappliction.dao;

import com.example.webappliction.entity.Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO {
    private static Connection conn;
    private static PreparedStatement pstmt;
    private static ResultSet rs;

    private static final String INSERT = "insert into employees values(?,?,?,?,?,?,?)";
    private static final String SELECT_ALL = "select * from employees";
    private static final String UPDATE ="UPDATE employees SET cmnd=?, fullname = ?,birthday =? , address =?, position=? ,department=?   WHERE  id =?";
    private static final String SELECT_BY_ID = "SELECT id,cmnd, fullname , birthday,address,position, department FROM employees WHERE id=?";
    public void insetEmployee(Employee employee) throws SQLException {
        conn = DBConnection.getMySQLConnection();
        pstmt = conn.prepareStatement(INSERT);
        pstmt.setString(1, employee.getCmnd());
        pstmt.setString(2,employee.getFullname());
        pstmt.setString(3,employee.getAddress());
        pstmt.setString(4,employee.getDepartment());
        pstmt.setDate(5,employee.getBirthday());
        pstmt.setString(6,employee.getPosition());
        pstmt.execute();
    }
    public List<Employee> selectAll() throws SQLException {
        conn = DBConnection.getMySQLConnection();
        List<Employee> employee = new ArrayList<Employee>();
        pstmt = conn.prepareStatement(SELECT_ALL);
        rs = pstmt.executeQuery();
        while (rs.next()) {
            Employee employee1 = new Employee();
            employee1.setId(rs.getInt("id"));
            employee1.setCmnd(rs.getString("cmnd"));
            employee1.setFullname(rs.getString("fullname"));
            employee1.setAddress(rs.getString("address"));
            employee1.setDepartment(rs.getString("department"));
            employee1.setBirthday(rs.getDate("birthday"));
            employee1.setPosition(rs.getString("position"));
            employee.add(employee1);

        }
        return employee;
    }
    public boolean updateEmployee(Employee employee) throws SQLException {
        conn = DBConnection.getMySQLConnection();
        pstmt = conn.prepareStatement(UPDATE);
        pstmt.setString(1, employee.getCmnd());
        pstmt.setString(2, employee.getFullname());
        pstmt.setString(3, employee.getAddress());
        pstmt.setString(4, employee.getDepartment());
        pstmt.setDate(5, employee.getBirthday());
        pstmt.setString(6, employee.getPosition());
        pstmt.setInt(7, employee.getId());
        return pstmt.executeUpdate() > 0;
    }
    public List<Employee> selectAllEmployee(int id) throws SQLException {
        List<Employee> users = new ArrayList<Employee>();
        conn = DBConnection.getMySQLConnection();
        pstmt = conn.prepareStatement(SELECT_BY_ID);
        rs = pstmt.executeQuery();
        while(rs.next()) {
           Employee employee1 = new Employee();
           employee1.setId(rs.getInt("id"));
           employee1.setCmnd(rs.getString("cmnd"));
           employee1.setFullname(rs.getString("fullname"));
           employee1.setAddress(rs.getString("address"));
           employee1.setDepartment(rs.getString("department"));
           employee1.setBirthday(rs.getDate("birthday"));
           employee1.setPosition(rs.getString("position"));
           users.add(employee1);

        }
        return users;
    }

}
