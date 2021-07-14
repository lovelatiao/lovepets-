package com.bing.service.type;

import com.bing.dao.BaseDao;
import com.bing.dao.type.TypeDaoImpl;

import java.sql.Connection;
import java.util.ArrayList;

public class TypeServiceImpl implements TypeService{

    @Override
    public ArrayList getType() {
        Connection connection = null;
        ArrayList arrayList = new ArrayList();
        try{
            connection = BaseDao.getConnection();
            arrayList = new TypeDaoImpl().getType(connection);
            return arrayList;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            BaseDao.closeResource(connection,null,null);
        }
        return null;
    }
}
