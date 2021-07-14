package com.bing.service.employee;

import com.bing.pojo.Owners;
import com.bing.pojo.Pets;
import com.bing.pojo.Visits;
import com.bing.service.owner.PetsOwnerServiceImpl;
import com.bing.service.pets.PetsServiceImpl;
import com.bing.service.type.TypeServiceImpl;
import com.bing.table.PetsTable;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class TestMain {
    public static void main(String[] args) throws Exception {
        ArrayList arrayList = null;
        arrayList = new PetsServiceImpl().petsQuery("112358","刘");
        for (int i = 0; i < arrayList.size(); i++) {
            PetsTable petsTable= (PetsTable) arrayList.get(i);
            System.out.println(petsTable.getOwner_name()+petsTable.getOwner_id());
        }

    }
}
