package com.learning.spring.workshop.service;

import com.learning.spring.workshop.dto.ItemDto;
import com.learning.spring.workshop.model.Item;

import java.util.List;

public interface ItemService {
    ItemDto findById(int id);
    void saveItem(Item item);
    void updateItem(Item item);
    void deleteItemById(int id);
    List<ItemDto> findAllItems();
}
