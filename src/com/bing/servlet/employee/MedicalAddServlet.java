package com.bing.servlet.employee;

import com.bing.pojo.Visits;
import com.bing.service.pets.PetsServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

public class MedicalAddServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pet_id = (String) req.getSession().getAttribute("pet_id");
        String description = req.getParameter("description");

        Date date = new Date();
        Visits visits = new Visits();
        visits.setPetId(Long.parseLong(pet_id));
        visits.setVisitDate(date);
        visits.setDescription(description);
        Boolean b = new PetsServiceImpl().medicalAdd(visits);
        if(b){
            req.getSession().setAttribute("message","病历添加成功");
            req.getRequestDispatcher("/lovepets/medicalMain.jsp").forward(req,resp);
        }else{
            req.getSession().setAttribute("message","病历添加错误");
            req.getRequestDispatcher("/lovepets/medicalMain.jsp").forward(req,resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
