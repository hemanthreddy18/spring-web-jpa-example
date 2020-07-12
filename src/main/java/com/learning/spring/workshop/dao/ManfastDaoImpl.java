package com.learning.spring.workshop.dao;

import com.learning.spring.workshop.model.Manfast;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ManfastDaoImpl extends AbstractDao<String, Manfast> implements ManfastDao {
    @Override
    public Manfast findById(int id) {
        return getByKey(id);
    }

    @Override
    public void addManfast(Manfast manfast) {
        persist(manfast);
    }

    @Override
    public void deleteManfastById(int id) {
        Manfast manfast = getByKey(id);
        if (manfast != null) {
            delete(manfast);
        } else {
            System.out.println("Manfast not found!");
        }
    }

    @Override
    public List<Manfast> getAllManfast() {
        List manfastList = getEntityManager()
                .createQuery("SELECT m FROM Manfast m LEFT JOIN FETCH m.products p ORDER BY m.name ASC")

                .getResultList();
        return manfastList;
    }
}
