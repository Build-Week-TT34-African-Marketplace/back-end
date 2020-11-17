package com.lambdaschool.bwafricanmarket.repositories;

import com.lambdaschool.bwafricanmarket.models.Item;
import org.springframework.data.repository.CrudRepository;

public interface ItemRepository extends CrudRepository<Item, Long> {
}
