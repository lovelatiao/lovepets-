package com.bing.pojo;


import java.util.Date;

public class Pets {

  private long id;
  private String name;
  private Date birthDate;
  private long typeId;
  private String owner_name;
  private String type_name;
  private long ownerId;

  public Pets(){

  }

  public Pets(long id ,String name,Date birthDate,String owner_name,String type_name,long ownerId){
    this.id = id;
    this.name = name;
    this.birthDate = birthDate;
    this.owner_name = owner_name;
    this.type_name = type_name;
    this.ownerId = ownerId;
  }

  public Pets(String name,Date birthDate,String owner_name,String type_name,long ownerId){
    this.name = name;
    this.birthDate = birthDate;
    this.owner_name = owner_name;
    this.type_name = type_name;
    this.ownerId = ownerId;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  public Date getBirthDate() {
    return birthDate;
  }

  public void setBirthDate(Date birthDate) {
    this.birthDate = birthDate;
  }


  public long getTypeId() {
    return typeId;
  }

  public void setTypeId(long typeId) {
    this.typeId = typeId;
  }


  public long getOwnerId() {
    return ownerId;
  }

  public void setOwnerId(long ownerId) {
    this.ownerId = ownerId;
  }

  public String getOwner_name() {
    return owner_name;
  }

  public void setOwner_name(String owner_name) {
    this.owner_name = owner_name;
  }

  public String getType_name() {
    return type_name;
  }

  public void setType_name(String type_name) {
    this.type_name = type_name;
  }
}
