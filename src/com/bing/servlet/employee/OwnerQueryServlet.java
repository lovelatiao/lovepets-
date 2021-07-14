package com.bing.servlet.employee;

import com.bing.service.pets.PetsServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class OwnerQueryServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        ArrayList arrayList = null;
        arrayList = new PetsServiceImpl().petsQuery("112358",name);
        req.getSession().setAttribute("owners",arrayList);
        req.getRequestDispatcher("/lovepets/ownerQueryTable.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
