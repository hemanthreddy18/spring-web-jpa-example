package com.learning.spring.workshop.service;

import com.learning.spring.workshop.dao.ManfastDao;
import com.learning.spring.workshop.model.Manfast;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@RequiredArgsConstructor
@Service("ManfastService")
@Transactional
public class ManfastServiceImpl implements ManfastService{

    private final ManfastDao manfastDao;

    @Override
    public Manfast findById(int id) {
        return manfastDao.findById(id);
    }

    @Override
    public void saveManfast(Manfast manfast) {
        manfastDao.addManfast(manfast);
    }

    @Override
    public void updateManfast(Manfast manfast) {
        Manfast entity = manfastDao.findById(manfast.getId());
        if(entity != null) {
            entity.setId(manfast.getId());
            entity.setName(manfast.getName());
            entity.setCountry(manfast.getCountry());
        }
    }

    @Override
    public void deleteManfastById(int id) {
        manfastDao.deleteManfastById(id);
    }

    @Override
    public List<Manfast> findAllManfasts() {
        List<Manfast> allManfast = manfastDao.getAllManfast();
     /*   for (Manfast man:
             allManfast) {
            System.out.println(man.getProducts());
        }*/
        //System.out.println(allManfast.get(0).getProducts());
        return allManfast;
    }

}
