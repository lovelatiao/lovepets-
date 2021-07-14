package com.bing.dao.employee;

import com.bing.dao.BaseDao;
import com.bing.pojo.Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class EmployeeDaoImpl implements EmployeeDao {

    public Employee getLoginEmployee(Connection connection, String name) throws Exception {

        PreparedStatement ptsm = null;
        ResultSet rs = null;
        Employee employee = null;

        if(connection != null){
            String sql = "select * from employee where name=?";
            Object[] params = {name};
            rs = BaseDao.execute(connection,params,sql,rs,ptsm);
            if(rs.next()){
                employee = new Employee();
                employee.setName(rs.getString("name"));
                employee.setPassword(rs.getString("password"));
            }
            BaseDao.closeResource(null,ptsm,rs);
        }
        return employee;
    }
}
