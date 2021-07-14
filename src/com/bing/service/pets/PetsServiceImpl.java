package com.bing.service.pets;

import com.bing.dao.BaseDao;
import com.bing.dao.owner.PetsOwnerDaoImpl;
import com.bing.dao.pets.PetsDaoImpl;
import com.bing.pojo.Owners;
import com.bing.pojo.Pets;
import com.bing.pojo.Visits;

import javax.swing.plaf.basic.BasicEditorPaneUI;
import java.sql.Connection;
import java.util.ArrayList;

public class PetsServiceImpl implements PetsService{

    @Override
    public boolean petsAdd(Pets pets) {
        Connection connection = null;
        try {
            connection = BaseDao.getConnection();
            return new PetsDaoImpl().petsAdd(connection,pets);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            BaseDao.closeResource(connection,null,null);
        }
        return false;
    }

    @Override
    public ArrayList petsQuery(String pet_name, String owner_name) {
        Connection connection = null;
        ArrayList arrayList = null;
        try{
            connection = BaseDao.getConnection();
            arrayList = new PetsDaoImpl().petsQuery(connection,pet_name,owner_name);
            return arrayList;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            BaseDao.closeResource(connection,null,null);
        }
        return null;
    }

    @Override
    public Pets petsQuery(String pet_id) {
        Connection connection = null;
        Pets pets = null;
        try{
            connection = BaseDao.getConnection();
            pets = new PetsDaoImpl().petsQuery(connection,pet_id);
            return pets;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            BaseDao.closeResource(connection,null,null);
        }
        return null;
    }

    @Override
    public Boolean petsModify(Pets pets) {
        Connection connection = null;
        try{
            connection = BaseDao.getConnection();
            return new PetsDaoImpl().petsModify(connection,pets);
        }catch (Exception e){
            e.printStackTrace();
        }finally{
            BaseDao.closeResource(connection,null,null);
        }
        return null;
    }

    @Override
    public Boolean medicalAdd(Visits visits) {
        Connection connection = null;
        try{
            connection = BaseDao.getConnection();
            return new PetsDaoImpl().medicalAdd(connection,visits);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            BaseDao.closeResource(connection,null,null);
        }
        return null;
    }

    @Override
    public ArrayList medicalQuery(String pet_id) {
        Connection connection = null;
        try{
            connection = BaseDao.getConnection();
            return new PetsDaoImpl().medicalQuery(connection,pet_id);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            BaseDao.closeResource(connection,null,null);
        }
        return null;
    }
}
