package com.bing.table;

public class PetsTable {
    private String pet_name ;
    private String owner_name;
    private String pet_id;
    private String owner_id;

    public PetsTable(){

    }
    public PetsTable(String pet_name, String owner_name, String pet_id, String owner_id){
        this.pet_name = pet_name;
        this.owner_name = owner_name;
        this.pet_id = pet_id;
        this.owner_id = owner_id;
    }

    public String getPet_name() {
        return pet_name;
    }

    public void setPet_name(String pet_name) {
        this.pet_name = pet_name;
    }

    public String getOwner_name() {
        return owner_name;
    }

    public void setOwner_name(String owner_name) {
        this.owner_name = owner_name;
    }

    public String getPet_id() {
        return pet_id;
    }

    public void setPet_id(String pet_id) {
        this.pet_id = pet_id;
    }

    public String getOwner_id() {
        return owner_id;
    }

    public void setOwner_id(String owner_id) {
        this.owner_id = owner_id;
    }
}
