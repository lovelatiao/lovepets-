package com.bing.service.vet;

import com.bing.pojo.Vets;
import com.bing.table.VetsTable;

import java.util.ArrayList;

public interface VetService {
    public abstract ArrayList VetQuery(String name, String specialty) throws Exception;
}
