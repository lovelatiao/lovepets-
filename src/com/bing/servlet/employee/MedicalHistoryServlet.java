package com.bing.servlet.employee;

import com.bing.pojo.Pets;
import com.bing.service.pets.PetsServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;

public class MedicalHistoryServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pet_id = (String)req.getSession().getAttribute("pet_id");
        System.out.println(pet_id);
        ArrayList arrayList = new PetsServiceImpl().medicalQuery(pet_id);
        req.getSession().setAttribute("medical",arrayList);
        req.getRequestDispatcher("/lovepets/medicalHistory.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
