package com.learning.spring.workshop.dao;

import com.learning.spring.workshop.model.Item;

import java.util.List;

public interface ItemDao {
    Item findById(int id);
    void addItem(Item items);
    void removeItemById(int id);
    List<Item> getAllItems();
}
