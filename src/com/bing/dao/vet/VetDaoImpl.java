package com.bing.dao.vet;

import com.bing.dao.BaseDao;
import com.bing.table.VetsTable;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class VetDaoImpl implements VetDao{
    @Override
    public ArrayList getVetQuery(Connection connection, String name,String specialty) throws Exception {
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        ArrayList arrayList = null;
        VetsTable vetsTable = null;
        if(connection!=null){
            String sql = null;
            Object[] params  = null;
            if(name != null && specialty == ""){
                System.out.println("specialty为空");
                params = new Object[]{"%" + name + "%"};
                sql = "select a.name,b.name from vets a,specialties b,vet_specialties c where a.id=c.vet_id and b.id=c.specialty_id and a.name LIKE ?";
            }else if(name == ""&&specialty != null){
                System.out.println("name为空");
                params = new Object[]{"%" + specialty + "%"};
                sql = "select a.name,b.name from vets a,specialties b,vet_specialties c where a.id=c.vet_id and b.id=c.specialty_id and b.name LIKE ?";
            }else if(name == ""&&specialty == ""){
                return null;
            }

            System.out.println(params[0]);
            try{
                rs = BaseDao.execute(connection,params,sql,rs,preparedStatement);
                rs.beforeFirst();
                arrayList = new ArrayList();
                while(rs.next()){
                    vetsTable = new VetsTable(rs.getString(1),rs.getString(2));
                    arrayList.add(vetsTable);
                }
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                BaseDao.closeResource(null,preparedStatement,rs);
            }

        }
        return arrayList;
    }
}
