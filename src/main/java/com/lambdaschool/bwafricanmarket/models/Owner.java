package com.lambdaschool.bwafricanmarket.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "owner")
public class Owner extends Auditable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonIgnoreProperties("ownerid")
    private long ownerid;
    private String fname;
    private String lname;
    public String getLname;

    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnoreProperties("owner")
    private Set<Own> owns = new HashSet<>();

    public Owner(){

    }

    public Owner(String fname, String lname){
        this.fname = fname;
        this.lname = lname;
    }

    public long getOwnerid() {
        return ownerid;
    }

    public void setOwnerid(long ownerid) {
        this.ownerid = ownerid;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public Set<Own> getOwns() {
        return owns;
    }

    public void setOwns(Set<Own> owns) {
        this.owns = owns;
    }

    @Override
    public Collection<Object> getmarkets() {
        return null;
    }
}
