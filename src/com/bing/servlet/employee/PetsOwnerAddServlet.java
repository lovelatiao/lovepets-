package com.bing.servlet.employee;

import com.bing.pojo.Owners;
import com.bing.service.owner.PetsOwnerServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class PetsOwnerAddServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String address = req.getParameter("address");
        String city = req.getParameter("city");
        String telephone = req.getParameter("telephone");
        Owners owners = new Owners(name,address,city,telephone);
        Boolean b = new PetsOwnerServiceImpl().ownerAdd(owners);
        req.getSession().setAttribute("message","所有人信息添加成功");
        if(b){
            req.getRequestDispatcher("/lovepets/pets.jsp").forward(req,resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
