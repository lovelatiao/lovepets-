package com.bing.service.owner;

import com.bing.dao.BaseDao;
import com.bing.dao.owner.PetsOwnerDaoImpl;
import com.bing.pojo.Owners;

import java.sql.Connection;

public class PetsOwnerServiceImpl implements PetsOwnerService{
    public PetsOwnerServiceImpl(){

    }
    @Override
    public Boolean ownerAdd(Owners owners) {
        Connection connection = null;
        try{
            connection = BaseDao.getConnection();
            return new PetsOwnerDaoImpl().ownerAdd(connection,owners);
         }catch (Exception e){
            e.printStackTrace();
            return false;
         }finally {
            BaseDao.closeResource(connection,null,null);
         }
    }

    @Override
    public Owners ownerQuery(String owner_id) {
        Connection connection = null;
        try{
            connection = BaseDao.getConnection();
            return new PetsOwnerDaoImpl().ownerQuery(connection,owner_id);
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            BaseDao.closeResource(connection,null,null);
        }
        return null;
    }

    @Override
    public Boolean ownerModify(Owners owners) {
        Connection connection = null;
        try{
            connection = BaseDao.getConnection();
            return new PetsOwnerDaoImpl().ownerModify(connection,owners);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            BaseDao.closeResource(connection,null,null);
        }
        return null;
    }
}
