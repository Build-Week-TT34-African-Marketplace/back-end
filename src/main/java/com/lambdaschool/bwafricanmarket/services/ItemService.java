package com.lambdaschool.bwafricanmarket.services;

import com.lambdaschool.bwafricanmarket.models.Item;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.Valid;
import java.util.List;

public interface ItemService {
    List<Item> findAll();
    Item findItemById(long id);
    Item findItemByName(String name);
    Item findItemByType(String type);
    void delete(long id);
    Item save(@Valid Item newItem);
    Item update(long id);

    @Transactional
    Item update(Item item, long id);

    void deleteAll();
}
