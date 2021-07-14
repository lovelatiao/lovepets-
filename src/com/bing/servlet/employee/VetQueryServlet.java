package com.bing.servlet.employee;

import com.bing.service.vet.VetServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class VetQueryServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String specialty = req.getParameter("specialty");
        if(name == "" && specialty == ""||(name !="" && specialty != "")){
            req.getSession().setAttribute("message","查询为空或者不支持同时查询");
            req.getRequestDispatcher("/lovepets/vets.jsp").forward(req,resp);
        }
        System.out.println("specialty的值为"+specialty);
        try {
            ArrayList arrayList = new VetServiceImpl().VetQuery(name,specialty);
            req.getSession().setAttribute("vets",arrayList);
            req.getRequestDispatcher("/lovepets/vetsQuery.jsp").forward(req,resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
