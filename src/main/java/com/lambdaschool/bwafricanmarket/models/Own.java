package com.lambdaschool.bwafricanmarket.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "own")
public class Own extends Auditable{
    @Id
    @OneToMany
    @JoinColumn(name = "ownerid")
    @JsonIgnoreProperties("owns")
    private Owner owner;

    @Id
    @ManyToOne
    @JoinColumn(name = "marketid")
    @JsonIgnoreProperties("owns")
    private Market market;

    public Own(){

    }

    public Own(Owner owner, Market market) {
        this.owner = owner;
        this.market = market;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public Market getMarket() {
        return market;
    }

    public void setMarket(Market market) {
        this.market = market;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj){
            return true;
        }
        if (!(obj instanceof Own)){
            return false;
        }
        Own that = (Own) obj;
        return ((owner == null) ? 0 : owner.getOwnerid()) == ((that.owner == null) ? 0 : that.owner.getOwnerid()) &&
                ((market == null) ? 0 : market.getMarketid()) == ((that.market == null) ? 0 : that.market.getMarketid());
    }
}
