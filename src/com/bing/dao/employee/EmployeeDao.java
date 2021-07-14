package com.bing.dao.employee;

import com.bing.pojo.Employee;

import java.sql.Connection;
import java.sql.SQLException;

public interface EmployeeDao {
    public Employee getLoginEmployee(Connection connection, String name) throws SQLException, Exception;
}
