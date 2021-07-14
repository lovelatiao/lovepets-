package com.bing.dao.owner;

import com.bing.pojo.Owners;

import java.sql.Connection;


public interface PetsOwnerDao {
    public abstract Boolean ownerAdd(Connection connect, Owners owners);
    public abstract Owners ownerQuery(Connection connection ,String owner_id);
    public abstract Boolean ownerModify(Connection connection,Owners owner);
}
