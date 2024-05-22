package com.example.webappliction.controller;

import com.example.webappliction.dao.EmployeeDAO;
import com.example.webappliction.entity.Employee;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/")
public class EmployeeServlet extends HttpServlet {
    private EmployeeDAO employeeDAO ;

    @Override
    public void init() throws ServletException {
        employeeDAO = new EmployeeDAO();
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       String action = req.getParameter("action");
       try{
           switch (action) {
               case "/new":
                   showNewForm(req,resp);
                   break; 
               case "/insert":
                   insertEmployee(req,resp);
                   break;
               case "/edit":
                   showEditFrom(req, resp);
                   break;
               case "/update":
                   updateEmployee(req,resp);
                   break;
               case "/list":
               default:
                   listEmployee(req,resp);
                   break;
           }
       }catch(Exception e){
         throw new ServletException(e);
       }
    }

    private void showEditFrom(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
        int id = Integer.parseInt(req.getParameter("id"));
        Employee user = (Employee) employeeDAO.selectAllEmployee(id);
        req.setAttribute("employee", user);
        RequestDispatcher dispatcher = req.getRequestDispatcher("employee-form.jsp");
        dispatcher.forward(req, resp);
    }

    private void listEmployee(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
        List<Employee> list = employeeDAO.selectAll();
        req.setAttribute("listEmployee", list);

        RequestDispatcher dispatcher = req.getRequestDispatcher("employee-list.jsp");
        dispatcher.forward(req, resp);
    }

    private void updateEmployee(HttpServletRequest req, HttpServletResponse resp) throws SQLException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String cmnd = req.getParameter("cmnd");
        String fullName = req.getParameter("fullName");
        Date birthdate = Date.valueOf(req.getParameter("birthdate"));
        String address = req.getParameter("address");
        String position = req.getParameter("position");
        String department = req.getParameter("department");
        Employee newUser = new Employee(id,cmnd,fullName,birthdate,address,position,department);
        employeeDAO.updateEmployee(newUser);
        resp.sendRedirect(req.getContextPath() + "/list");
    }

    private void insertEmployee(HttpServletRequest req, HttpServletResponse resp) throws SQLException, IOException {
        String cmnd = req.getParameter("cmnd");
        String fullName = req.getParameter("fullName");
        Date birthday = Date.valueOf(req.getParameter("birthday"));
        String address = req.getParameter("address");
        String position = req.getParameter("position");
        String department = req.getParameter("department");
        Employee newUser = new Employee(cmnd,fullName,birthday,address,position,department);
        employeeDAO.updateEmployee(newUser);
        resp.sendRedirect(req.getContextPath() + "/list");

    }

    private void showNewForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("employee-form.jsp");
        dispatcher.forward(req, resp);
    }
}
