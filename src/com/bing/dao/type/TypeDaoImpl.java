package com.bing.dao.type;

import com.bing.dao.BaseDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class TypeDaoImpl implements TypeDao{
    @Override
    public ArrayList getType(Connection connection) {
        ArrayList arrayList = new ArrayList();
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        try{
            String sql = "select name from types";
            Object[] params = {};
            rs = BaseDao.execute(connection,params,sql,rs,preparedStatement);
            while(rs.next()){
                arrayList.add(rs.getString(1));
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
