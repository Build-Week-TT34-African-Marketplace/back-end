package com.lambdaschool.bwafricanmarket.models;

import java.util.Objects;

public class OwnId {
    private long owner;
    private long market;

    public OwnId() {
    }

    public long getOwner() {
        return owner;
    }

    public void setOwner(long owner) {
        this.owner = owner;
    }

    public long getMarket() {
        return market;
    }

    public void setMarket(long market) {
        this.market = market;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj){
            return true;
        }
        if (obj == null || getClass() != obj.getClass()){
            return false;
        }
        OwnId ownId = (OwnId) obj;
        return owner == ownId.owner && market == ownId.market;
    }

    @Override
    public int hashCode() {
        return Objects.hash(owner, market);
    }
}
