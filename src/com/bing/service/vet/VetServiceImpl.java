package com.bing.service.vet;

import com.bing.dao.BaseDao;
import com.bing.dao.vet.VetDaoImpl;

import java.sql.Connection;
import java.util.ArrayList;

public class VetServiceImpl implements VetService {
    private VetDaoImpl vetDao;

    public VetServiceImpl() {
        vetDao = new VetDaoImpl();
    }

    @Override
    public ArrayList VetQuery(String name, String specialty) throws Exception {
        Connection connection = null;
        connection = BaseDao.getConnection();
        ArrayList arrayList = null;
        try {
            arrayList = vetDao.getVetQuery(connection, name, specialty);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeResource(connection, null, null);
        }

        return arrayList;
    }
}
