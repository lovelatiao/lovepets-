package com.bing.dao.pets;

import com.bing.dao.BaseDao;
import com.bing.pojo.Pets;
import com.bing.pojo.Visits;
import com.bing.table.PetsTable;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class PetsDaoImpl implements PetsDao{
    @Override
    public boolean petsAdd(Connection connection, Pets pets) {
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        try{
            String sql = "insert into pets values(?,?,?,(select id from types where name=?),?) ";
            String sql2 = "select name from owners where id=?";
            Object[] params = {null,pets.getName(),pets.getBirthDate(),pets.getType_name(),pets.getOwnerId()};
            Object[] params2 = {pets.getOwnerId()};
            rs = BaseDao.execute(connection,params2,sql2,rs,preparedStatement);
            rs.next();
            if(!rs.getString(1).equals(pets.getOwner_name()) || rs.getString(1) == null){
                System.out.println("用户名检测");
                return false;
            }
            BaseDao.execute(connection,params,sql,preparedStatement);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }finally {
            BaseDao.closeResource(null,preparedStatement,rs);
        }
    }

    @Override
    public ArrayList petsQuery(Connection connection, String pet_name, String owner_name) {
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        String sql = null;
        Object[] params = null;
        ArrayList arrayList = new ArrayList();
        PetsTable petsTable = null;
        try{
            if(pet_name != "" && owner_name == ""){
                sql = "select p.name,o.name,p.id,o.id from pets p,owners o where p.owner_id=o.id AND p.name like ?";
                params = new Object[]{"%"+pet_name+"%"};
            }else if(pet_name == "" && owner_name !=""){
                sql = "select p.name,o.name,p.id,o.id from pets p,owners o where p.owner_id=o.id AND o.name like ?";
                params = new Object[]{"%"+owner_name+"%"};
            }else if(pet_name == "112358" && owner_name !=""){
                sql = "select o.name,o.name,o.id,o.id from owners o where o.name like ?";
                params = new Object[]{"%"+owner_name+"%"};
            }else if(pet_name == "" && owner_name == ""){
                return null;
            }
            rs = BaseDao.execute(connection,params,sql,rs,preparedStatement);
            rs.beforeFirst();
            while (rs.next()){
                petsTable = new PetsTable(rs.getString(1),rs.getString(2),
                        rs.getString(3),rs.getString(4));
                arrayList.add(petsTable);
            }
            return arrayList;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            BaseDao.closeResource(null,preparedStatement,rs);
        }
        return null;
    }

    @Override
    public Pets petsQuery(Connection connection, String pet_id) {
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        Pets pets = null;
        try{
            String sql = "select p.name,t.name,p.birth_date,o.name,o.id from pets p,owners o,types t where p.id=? AND p.type_id=t.id AND p.owner_id=o.id";
            Object[] params = {pet_id};
            rs = BaseDao.execute(connection,params,sql,rs,preparedStatement);
            rs.beforeFirst();
            while(rs.next()){
                pets = new Pets();
                pets.setName(rs.getString(1));
                pets.setType_name(rs.getString(2));
                pets.setBirthDate(rs.getDate(3));
                pets.setOwner_name(rs.getString(4));
                pets.setOwnerId(Long.parseLong(rs.getString(5)));
            }
            pets.setId(Long.parseLong(pet_id));
            return pets;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            BaseDao.closeResource(null,preparedStatement,rs);
        }
        return null;
    }

    @Override
    public boolean petsModify(Connection connection, Pets pets) {
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        try{
            String sql = "update pets set name=?,birth_date=?,type_id=(select id from types where name=?),owner_id=? where id=?";
            String sql3 = "select name from owners where id=?";
            Object[] params = {pets.getName(),pets.getBirthDate(),pets.getType_name(),pets.getOwnerId(),pets.getId()};
            Object[] params3 = {pets.getOwnerId()};
            rs = BaseDao.execute(connection,params3,sql3,rs,preparedStatement);
            rs.next();
            if(!rs.getString(1).equals(pets.getOwner_name()) || rs.getString(1) == null){
                System.out.println("用户名检测");
                return false;
            }
            BaseDao.execute(connection,params,sql,preparedStatement);
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }finally{
            BaseDao.closeResource(null,preparedStatement,rs);
        }
        return false;
    }

    @Override
    public Boolean medicalAdd(Connection connection, Visits visits) {
        PreparedStatement preparedStatement = null;
        try{
            String sql = "insert into visits values(?,?,?,?)";
            Object[] params = {null,visits.getPetId(),visits.getVisitDate(),visits.getDescription()};
            BaseDao.execute(connection,params,sql,preparedStatement);
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            BaseDao.closeResource(null,preparedStatement,null);
        }
        return null;
    }

    @Override
    public ArrayList medicalQuery(Connection connection, String pet_id) {
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        ArrayList arrayList = null;
        Visits visits = null;
        try{
            String sql = "select visit_date,description from visits where pet_id=?";
            Object[] params = {Long.parseLong(pet_id)};
            rs = BaseDao.execute(connection,params,sql,rs,preparedStatement);
            rs.beforeFirst();
            arrayList = new ArrayList();
            while (rs.next()){
                visits = new Visits();
                visits.setVisitDate(rs.getDate(1));
                visits.setDescription(rs.getString(2));
                arrayList.add(visits);
            }
            return arrayList;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            BaseDao.closeResource(null,preparedStatement,rs);
        }
        return null;
    }
}
