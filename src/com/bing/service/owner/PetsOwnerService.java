package com.bing.service.owner;

import com.bing.pojo.Owners;

import java.security.acl.Owner;

public interface PetsOwnerService {
    public abstract Boolean ownerAdd(Owners owner);
    public abstract Owners ownerQuery(String owner_id);
    public abstract Boolean ownerModify(Owners owners);
}
