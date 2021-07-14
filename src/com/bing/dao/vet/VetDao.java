package com.bing.dao.vet;

import com.bing.pojo.Vets;
import com.bing.table.VetsTable;

import java.sql.Connection;
import java.util.ArrayList;

public interface VetDao {
    public ArrayList getVetQuery(Connection connection, String name, String specialty) throws Exception;
}
