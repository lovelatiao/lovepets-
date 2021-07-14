package com.bing.servlet.employee;

import com.bing.pojo.Pets;
import com.bing.service.pets.PetsServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PetsAddServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String type = req.getParameter("type");
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        ParsePosition pos = new ParsePosition(0);
        Date currentTime_2 = formatter.parse(req.getParameter("birthday"), pos);
        String owner_name = req.getParameter("owner_name");
        long owner_id = Long.parseLong(req.getParameter("owner_id"));

        Pets pets = new Pets(name,currentTime_2,owner_name,type,owner_id);
        Boolean b = new PetsServiceImpl().petsAdd(pets);
        if(!b){
            req.getSession().setAttribute("message","添加失败：所属人名字和唯一id不匹配");
        }else {
            req.getSession().setAttribute("message","宠物信息添加成功");
        }
        req.getRequestDispatcher("/lovepets/pets.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
