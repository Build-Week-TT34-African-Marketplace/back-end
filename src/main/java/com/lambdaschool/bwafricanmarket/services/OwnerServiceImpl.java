package com.lambdaschool.bwafricanmarket.services;

import com.lambdaschool.bwafricanmarket.exceptions.ResourceFoundException;
import com.lambdaschool.bwafricanmarket.exceptions.ResourceNotFoundException;
import com.lambdaschool.bwafricanmarket.models.Owner;
import com.lambdaschool.bwafricanmarket.repositories.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Transactional
@Service("ownerService")
public class OwnerServiceImpl implements OwnerService{
    @Autowired
    OwnerRepository ownerrespos;
    @Override
    public List<Owner> findAll(){
        List<Owner> list = new ArrayList<>();
        ownerrespos.findAll().iterator().forEachRemaining(list::add);
        return list;
    }

    @Override
    public Owner findOwnerById(long id){
        return (Owner) ownerrespos.findAllById(id).orElseThrow(()-> new ResourceNotFoundException("Owner with id " + id + " Not Found!"));
    }
    @Transactional
    @Override
    public void delete(long id){
        if (ownerrespos.findById(id).isPresent()){
            ownerrespos.deleteById(id);
        }
        else{
            throw new ResourceNotFoundException("Owner with id " + id + " Not Found!");
        }
    }
    @Transactional
    @Override
    public Owner save(Owner owner){
        if (owner.getOwns().size() > 0){
            throw new ResourceFoundException("Owns are not added through Owner.");
        }

        Owner newOwner = new Owner();
        newOwner.setFname(owner.getFname());
        newOwner.setLname(owner.getLname());
        return ownerrespos.save(newOwner);
    }
    @Transactional
    @Override
    public Owner update(Owner owner, long id){
        Owner currentOwner = findOwnerById(id);
        if (owner.getOwns().size()>0){
            throw new ResourceFoundException("Owns are not updated through Owner");
        }
        if (owner.getFname() != null){
            currentOwner.setFname(owner.getFname());
        }
        if(owner.getLname() != null){
            currentOwner.setLname(owner.getLname);
        }
        return currentOwner;
    }

    @Override
    public void deleteAll() {

    }
}
