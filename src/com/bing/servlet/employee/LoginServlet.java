package com.bing.servlet.employee;

import com.bing.pojo.Employee;
import com.bing.service.employee.EmployeeService;
import com.bing.service.employee.EmployeeServiceImpl;
import com.bing.util.Constants;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("start");
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        EmployeeService employeeService = new EmployeeServiceImpl();
        Employee employee = employeeService.login(name,password);

        System.out.println(employee.getName());
        System.out.println(employee.getPassword());
        if(employee.getName().equals(name)&&employee.getPassword().equals(password)){
            req.getSession().setAttribute("admin",employee);
            req.getRequestDispatcher("lovepets/vets.jsp").forward(req,resp);
            System.out.println("密码账户正确");
            return;
        }else{
            req.setAttribute("error","错误");
            resp.sendRedirect("index.jsp");
        }
    }

}
