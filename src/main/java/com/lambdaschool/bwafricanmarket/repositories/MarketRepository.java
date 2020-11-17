package com.lambdaschool.bwafricanmarket.repositories;

import com.lambdaschool.bwafricanmarket.models.Market;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface MarketRepository extends CrudRepository<Market, Long> {
    Optional<Object> findByLocation(String location);
}
