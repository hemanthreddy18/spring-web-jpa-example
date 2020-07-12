package com.learning.spring.workshop.dao;

import com.learning.spring.workshop.model.Manfast;

import java.util.List;

public interface ManfastDao {

    Manfast findById(int id);
    void addManfast(Manfast manfast);
    void deleteManfastById(int id);
    List<Manfast> getAllManfast();
}