package com.bing.servlet.employee;

import com.bing.service.pets.PetsServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class PetsQueryServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pet_name = req.getParameter("pet_name");
        String owner_name = req.getParameter("owner_name");
        if(pet_name == "" && owner_name == ""||(pet_name !="" && owner_name != "")){
            req.getSession().setAttribute("message","查询为空或者不支持同时查询");
            req.getRequestDispatcher("/lovepets/pets.jsp").forward(req,resp);
        }
        ArrayList arrayList = null;
        arrayList = new PetsServiceImpl().petsQuery(pet_name,owner_name);
        req.getSession().setAttribute("pets",arrayList);
        req.getRequestDispatcher("/lovepets/petsQuery.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
