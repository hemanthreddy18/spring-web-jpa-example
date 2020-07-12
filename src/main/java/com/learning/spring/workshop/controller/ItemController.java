package com.learning.spring.workshop.controller;

import com.learning.spring.workshop.dto.ItemDto;
import com.learning.spring.workshop.model.Item;
import com.learning.spring.workshop.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/item")
@RequiredArgsConstructor
public class ItemController {

    private final ItemService itemService;

    @GetMapping
    public List<ItemDto> listItems() {
        return itemService.findAllItems();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ItemDto> getItemById(@PathVariable("id") int id){
        ItemDto byId = itemService.findById(id);
        if (byId == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(byId, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> createItem(@RequestBody Item items) {
        itemService.saveItem(items);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping
    public void updateItem(@RequestBody Item items) {
        itemService.updateItem(items);
    }

    @DeleteMapping("/{id}")
    public void removeItem(@PathVariable("id") int id) {
        itemService.deleteItemById(id);
    }
}
