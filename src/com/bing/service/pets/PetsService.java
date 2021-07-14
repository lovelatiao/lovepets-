package com.bing.service.pets;

import com.bing.pojo.Owners;
import com.bing.pojo.Pets;
import com.bing.pojo.Visits;

import java.util.ArrayList;

public interface PetsService {
    public abstract boolean petsAdd(Pets pets);
    public abstract ArrayList petsQuery(String pet_name,String owner_name);
    public abstract Pets petsQuery(String pet_id);
    public abstract Boolean petsModify(Pets pets);
    public abstract Boolean medicalAdd(Visits visits);
    public abstract ArrayList medicalQuery(String pet_id);

}
