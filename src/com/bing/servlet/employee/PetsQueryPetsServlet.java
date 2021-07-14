package com.bing.servlet.employee;

import com.bing.pojo.Pets;
import com.bing.service.pets.PetsServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class PetsQueryPetsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pet_id = req.getParameter("pet_id");
        req.getSession().setAttribute("pet_id",pet_id);
        Pets pets = new PetsServiceImpl().petsQuery(pet_id);
        pets.setId(Long.parseLong(pet_id));
        req.getSession().setAttribute("pets_pets",pets);
        req.getRequestDispatcher("/lovepets/medicalMain.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
