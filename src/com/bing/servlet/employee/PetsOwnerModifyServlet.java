package com.bing.servlet.employee;

import com.bing.pojo.Owners;
import com.bing.service.owner.PetsOwnerServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class PetsOwnerModifyServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        String name = req.getParameter("name");
        String address = req.getParameter("address");
        String city = req.getParameter("city");
        String telephone = req.getParameter("telephone");
        Owners owner = new Owners(Long.parseLong(req.getParameter("id")),
                req.getParameter("name"),req.getParameter("address"),req.getParameter("city"),req.getParameter("telephone"));
        Boolean b = new PetsOwnerServiceImpl().ownerModify(owner);
        if(b){
            req.getSession().setAttribute("message","修改所有人信息成功");
        }
        req.getRequestDispatcher("/lovepets/pets.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
