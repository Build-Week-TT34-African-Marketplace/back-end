package com.lambdaschool.bwafricanmarket.services;

import com.lambdaschool.bwafricanmarket.models.Owner;

import java.util.List;

public interface OwnerService {
    List<Owner> findAll();
    Owner findOwnerById(long id);
    void delete(long id);
    Owner save(Owner role);
    Owner update(Owner role, long id);
    void deleteAll();
}
