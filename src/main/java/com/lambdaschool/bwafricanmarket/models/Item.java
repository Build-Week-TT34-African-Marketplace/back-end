package com.lambdaschool.bwafricanmarket.models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "items")
public class Item extends Auditable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long itemid;
    private String name;
    private String type;
    private int price;

    @ManyToOne
    @JoinColumn(name = "marketid")
    @JsonIgnoreProperties("market")
    private Market market;

    public Item() {
    }

    public Item(String name, String type, int price, Market market) {
        this.name = name;
        this.type = type;
        this.price = price;
        this.market = market;
    }

    public long getItemid() {
        return itemid;
    }

    public void setItemid(long itemid) {
        this.itemid = itemid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Market getMarket() {
        return market;
    }

    public void setMarket(Market market) {
        this.market = market;
    }
}
