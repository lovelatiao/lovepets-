package com.bing.servlet.employee;

import com.bing.pojo.Owners;
import com.bing.service.owner.PetsOwnerServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class PetsQueryOwnerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String owner_id = req.getParameter("owner_id");
        Owners owners = new PetsOwnerServiceImpl().ownerQuery(owner_id);
        req.getSession().setAttribute("owners",owners);
        req.getRequestDispatcher("/lovepets/petsOwnerModify.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
