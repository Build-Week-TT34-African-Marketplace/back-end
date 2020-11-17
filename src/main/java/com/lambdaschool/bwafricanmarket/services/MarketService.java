package com.lambdaschool.bwafricanmarket.services;

import com.lambdaschool.bwafricanmarket.models.Market;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface MarketService {
    List<Market> findAll();
    Market findMarketById(long id);
    Market findMarketByLocation(Long location);

    Market findMarketByLocation(String location);

    void delete(long id);
    Market save(Market role);
    Market update(Market role, long id);

    @Transactional
    void deleteAll();
}
