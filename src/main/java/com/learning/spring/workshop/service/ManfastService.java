package com.learning.spring.workshop.service;

import com.learning.spring.workshop.model.Manfast;

import java.util.List;

public interface ManfastService {

    Manfast findById(int id);

    void saveManfast(Manfast manfast);

    void updateManfast(Manfast manfast);

    void deleteManfastById(int id);

    List<Manfast> findAllManfasts();
}
