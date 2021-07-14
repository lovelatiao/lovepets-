package com.bing.service.employee;

import com.bing.dao.BaseDao;
import com.bing.dao.employee.EmployeeDao;
import com.bing.dao.employee.EmployeeDaoImpl;
import com.bing.pojo.Employee;

import java.sql.Connection;

public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeDao employeeDao;
    public EmployeeServiceImpl(){
        employeeDao = new EmployeeDaoImpl();
    }

    public Employee login(String name, String password) {
        Connection connection = null;
        Employee employee = null;
        connection = BaseDao.getConnection();
        try {
            employee = employeeDao.getLoginEmployee(connection,name);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            BaseDao.closeResource(connection,null,null);
        }
        return employee;
    }

}
