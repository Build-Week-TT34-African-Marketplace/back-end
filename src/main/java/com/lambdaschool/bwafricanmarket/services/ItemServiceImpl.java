package com.lambdaschool.bwafricanmarket.services;


import com.lambdaschool.bwafricanmarket.models.Item;
import com.lambdaschool.bwafricanmarket.models.User;
import com.lambdaschool.bwafricanmarket.repositories.ItemRepository;
import com.lambdaschool.bwafricanmarket.repositories.MarketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Service("itemService")
public class ItemServiceImpl implements ItemService{
    @Autowired
    UserAuditing userAuditing;
    @Autowired
    ItemRepository itemrepos;
    @Autowired
    MarketRepository marketRepos;
    @Autowired
    MarketService marketService;
    @Override
    public List<Item> findAll(){
        List<Item> list = new ArrayList<>();
        itemrepos.findAll().iterator().forEachRemaining(list::add);
        return list;
    }

    @Override
    public Item findItemById(long id){
        return itemrepos.findById(id).orElseThrow(()-> new EntityNotFoundException("Item with id" + id + "not found"));
    }

    @Override
    public Item findItemByName(String name) {
        return null;
    }

    @Override
    public Item findItemByType(String type) {
        return null;
    }

    @Transactional
    @Override
    public void delete(long id){
        if (itemrepos.findById(id).isPresent()){
            itemrepos.deleteById(id);
        }
        else{
            throw new EntityNotFoundException("Item with id" + id + "not found");
        }
    }
    @Transactional
    @Override
    public Item save(Item item){
        Item newItem = new Item();
        if (item.getItemid() != 0){
            itemrepos.findById(item.getItemid()).orElseThrow(() -> new EntityNotFoundException("Item id" + item.getItemid() + "not found"));
        }
        newItem.setName(item.getName());
        newItem.setType(item.getType());
        newItem.setPrice(item.getPrice());
        if (item.getMarket() != null){
            newItem.setMarket(marketService.findMarketById(item.getMarket().getMarketid()));
        }
        return itemrepos.save(newItem);
    }

    @Override
    public Item update(long id) {
        return null;
    }

    @Transactional
    @Override
    public Item update(Item item, long id){
        Item currentItem = findItemById(id);
        if (item.getName() != null){
            currentItem.setName(item.getName());
        }
        if (item.getType() != null){
            currentItem.setType(item.getType());
        }
        if (item.getPrice() != 0){
            currentItem.setPrice(item.getPrice());
        }
        return itemrepos.save(currentItem);
    }
    @Transactional
    @Override
    public void deleteAll(){
        itemrepos.deleteAll();
    }
}
