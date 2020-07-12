package com.learning.spring.workshop.service;

import com.learning.spring.workshop.dao.ItemDao;
import com.learning.spring.workshop.dto.ItemDto;
import com.learning.spring.workshop.dto.ManifacturerDto;
import com.learning.spring.workshop.dto.ProductDto;
import com.learning.spring.workshop.model.Item;
import com.learning.spring.workshop.model.Manfast;
import com.learning.spring.workshop.model.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service("ItemService")
@Transactional
public class ItemServiceImpl implements ItemService {
    private final ItemDao itemDao;

    @Override
    public ItemDto findById(int id) {
        Item item = itemDao.findById(id);
        if (item == null) {
            return null;
        }
        return buildItemDto(item);
    }

    @Override
    public void saveItem(Item item) {
        itemDao.addItem(item);
    }

    @Override
    public void updateItem(Item item) {
        Item entity = itemDao.findById(item.getId());
        if (entity != null) {
            entity.setId(item.getId());
            entity.setName(item.getName());
            entity.setDescription(item.getDescription());
            entity.setProduct(item.getProduct());
        }
    }

    @Override
    public void deleteItemById(int id) {
        itemDao.removeItemById(id);
    }

    @Override
    public List<ItemDto> findAllItems() {
        List<Item> items = itemDao.getAllItems();
        List<ItemDto> itemDtos = new ArrayList<>();
        for (Item item : items) {
            ItemDto dto = buildItemDto(item);
            itemDtos.add(dto);
        }
        return itemDtos;
    }

    private ItemDto buildItemDto(Item item) {
        Product itemProduct = item.getProduct();
        Manfast manfast = itemProduct.getManfast();
        ManifacturerDto manifacturer = ManifacturerDto.builder()
                .id(manfast.getId())
                .name(manfast.getName())
                .build();
        ProductDto product = ProductDto.builder()
                .id(itemProduct.getId())
                .name(itemProduct.getName())
                .manifacturer(manifacturer)
                .build();
        return ItemDto.builder()
                .id(item.getId())
                .name(item.getName())
                .description(item.getDescription())
                .productDto(product)
                .build();
    }
}
