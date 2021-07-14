package com.bing.dao.pets;

import com.bing.pojo.Pets;
import com.bing.pojo.Visits;

import java.sql.Connection;
import java.util.ArrayList;

public interface PetsDao {
    public abstract boolean petsAdd(Connection connection, Pets pets);
    public abstract ArrayList petsQuery(Connection connection,String pet_name,String owner_name);
    public abstract Pets petsQuery(Connection connection,String pet_id);
    public abstract boolean petsModify(Connection connection,Pets pets);
    public abstract Boolean medicalAdd(Connection connection, Visits visits);
    public abstract ArrayList medicalQuery(Connection connection,String pet_id);
}
