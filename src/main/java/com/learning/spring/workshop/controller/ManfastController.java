package com.learning.spring.workshop.controller;

import com.learning.spring.workshop.model.Manfast;
import com.learning.spring.workshop.service.ManfastService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/manfast")
@RequiredArgsConstructor
public class ManfastController {

    private final ManfastService manfastService;

    @GetMapping
    public List<Manfast> listUsers() {
        return manfastService.findAllManfasts();
    }

    @GetMapping("/{id}")
    public Manfast getById(@PathVariable("id") int id) {
        return manfastService.findById(id);
    }

    @PostMapping
    public void createManfast(@RequestBody Manfast manfast) {
        manfastService.saveManfast(manfast);
    }

    @DeleteMapping("/{id}")
    public void removeManfast(@PathVariable("id") int id) {
        manfastService.deleteManfastById(id);
    }
    @PutMapping()
    public void updateManfast(@RequestBody Manfast manfast) {
        manfastService.updateManfast(manfast);
    }
}
