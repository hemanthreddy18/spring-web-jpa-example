package com.learning.spring.workshop.dao;

import com.learning.spring.workshop.model.Item;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ItemDaoImpl extends AbstractDao<String, Item> implements ItemDao {

    @Override
    public Item findById(int id) { return getByKey(id); }

    @Override
    public void addItem(Item items) {
        persist(items);
    }

    @Override
    public void removeItemById(int id) {
        Item items = (Item) getByKey(id);
        if (items != null) {
            delete(items);
        } else {
            System.out.println("Item not found!");
        }
    }

    @Override
    public List<Item> getAllItems() {
        List itemList = getEntityManager()
                .createQuery("Select i from Item i Join FETCH i.product Join i.product.manfast Order By i.name ASC")
                .getResultList();
        return itemList;
    }
}
