package com.bing.dao.owner;

import com.bing.dao.BaseDao;
import com.bing.pojo.Owners;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class PetsOwnerDaoImpl implements PetsOwnerDao{
    @Override
    public Boolean ownerAdd(Connection connection,Owners owners) {
        PreparedStatement preparedStatement = null;
        try{
            Object[] params = {null,owners.getName(),owners.getAddress(),owners.getCity(),owners.getTelephone()};
            String sql = "insert into owners values(?,?,?,?,?)";
            BaseDao.execute(connection,params,sql,preparedStatement);
            return true;
        }catch (Exception e){
           e.printStackTrace();
           return false;
        }finally {
            BaseDao.closeResource(null,preparedStatement,null);
        }
    }

    @Override
    public Owners ownerQuery(Connection connection, String owner_id) {
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        Owners owners = null;
        try{
            String sql = "select name,address,city,telephone from owners where id=?";
            Object[] params = {owner_id};
            rs = BaseDao.execute(connection,params,sql,rs,preparedStatement);
            rs.beforeFirst();
            while(rs.next()){
                owners = new Owners();
                owners.setName(rs.getString(1));
                owners.setAddress(rs.getString(2));
                owners.setCity(rs.getString(3));
                owners.setTelephone(rs.getString(4));
            }
            owners.setId(Long.parseLong(owner_id));
            return owners;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            BaseDao.closeResource(null,preparedStatement,rs);
        }
        return null;
    }

    @Override
    public Boolean ownerModify(Connection connection, Owners owners) {
        PreparedStatement preparedStatement = null;
        try{
            String sql = "update owners set name=?,address=?,city=?,telephone=? where id=?";
            Object[] params = {owners.getName(),owners.getAddress(),owners.getCity(),owners.getTelephone(),owners.getId()};
            BaseDao.execute(connection,params,sql,preparedStatement);
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            BaseDao.closeResource(null,preparedStatement,null);
        }
        return false;
    }
}
