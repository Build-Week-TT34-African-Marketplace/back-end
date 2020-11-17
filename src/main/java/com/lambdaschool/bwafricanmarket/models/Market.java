package com.lambdaschool.bwafricanmarket.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "market")
public class Market extends Auditable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long marketid;
    private String name;
    private String location;

    @ManyToMany
    @JoinColumn(name = "sectionid")
    @JsonIgnoreProperties("market")
    private Section section;

    @OneToMany
    @JoinColumn(name = "itemid")
    @JsonIgnoreProperties("market")
    private Item item;

    @OneToMany(mappedBy = "market", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnoreProperties("market")
    private Set<Own> owns = new HashSet<>();

    public Market(){

    }

    public Market(String name, String location, Section section) {
        this.name = name;
        this.location = location;
        this.section = section;
    }

    public long getMarketid() {
        return marketid;
    }

    public void setMarketid(long marketid) {
        this.marketid = marketid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Section getSection() {
        return section;
    }

    public void setSection(Section section) {
        this.section = section;
    }

    public Set<Own> getOwns() {
        return owns;
    }

    public void setOwns(Set<Own> owns) {
        this.owns = owns;
    }
}
