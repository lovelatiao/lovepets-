package com.bing.servlet.employee;

import com.bing.pojo.Pets;
import com.bing.service.pets.PetsServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PetsModifyServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pet_id = req.getParameter("pet_id");
        String name = req.getParameter("name");
        String type = req.getParameter("type");
        String owner_name = req.getParameter("owner_name");
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        ParsePosition pos = new ParsePosition(0);
        Date currentTime_2 = formatter.parse(req.getParameter("birth_date"), pos);
        Date date = currentTime_2;
        String owner_id = req.getParameter("owner_id");
        Pets pets = new Pets();
        pets.setId(Long.parseLong(pet_id));
        pets.setName(name);
        pets.setBirthDate(date);
        pets.setType_name(type);
        pets.setOwner_name(owner_name);
        pets.setOwnerId(Long.parseLong(owner_id));
        Boolean b = new PetsServiceImpl().petsModify(pets);
        if(b){
            req.getSession().setAttribute("message","宠物信息修改成功");
            req.getRequestDispatcher("/lovepets/medicalMain.jsp").forward(req,resp);
        }else{
            req.getSession().setAttribute("message","宠物信息修改失败，请检查是否符合逻辑");
            req.getRequestDispatcher("/lovepets/medicalMain.jsp").forward(req,resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
