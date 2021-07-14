package com.bing.pojo;


public class Owners {

  private long id;
  private String name;
  private String address;
  private String city;
  private String telephone;

  public Owners(String name, String address, String city, String telephone){
    this.name = name;
    this.address = address;
    this.city = city;
    this.telephone = telephone;
  }

  public Owners() {

  }

  public Owners(long id,String name,String address,String city,String telephone){
    this.id = id;
    this.name = name;
    this.address = address;
    this.city = city;
    this.telephone = telephone;

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


  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }


  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }


  public String getTelephone() {
    return telephone;
  }

  public void setTelephone(String telephone) {
    this.telephone = telephone;
  }

}
