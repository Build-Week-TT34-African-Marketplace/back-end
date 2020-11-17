package com.lambdaschool.bwafricanmarket.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "section")
public class Section extends Auditable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long sectionid;
    private String name;

    @ManyToMany(mappedBy = "section")
    @JsonIgnoreProperties("section")
    private Set<Market> markets = new HashSet<>();

    public Section(){

    }

    public Section(String name) {
        this.name = name;
    }

    public long getSectionid() {
        return sectionid;
    }

    public void setSectionid(long sectionid) {
        this.sectionid = sectionid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Market> getMarkets() {
        return markets;
    }

    public void setMarkets(Set<Market> markets) {
        this.markets = markets;
    }

    @Override
    public Collection<Object> getmarkets() {
        return null;
    }
}
