package com.workintech.FruitsVegetables.Rest.Api.services;

import com.workintech.FruitsVegetables.Rest.Api.dao.VegetableRepository;
import com.workintech.FruitsVegetables.Rest.Api.entity.Vegetable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VegetableServiceImpl implements VegetableService{

    private VegetableRepository vegetableRepository;

    @Autowired
    public VegetableServiceImpl(VegetableRepository vegetableRepository) {
        this.vegetableRepository = vegetableRepository;
    }

    @Override
    public List<Vegetable> find() {
        return vegetableRepository.findAll();
    }

    @Override
    public Vegetable findById(int id) {
        Optional<Vegetable> vegetable = vegetableRepository.findById(id);
        if(vegetable.isPresent()){
            return vegetable.get();
        }
        return null;
    }

    @Override
    public Vegetable save(Vegetable vegetable) {
        return vegetableRepository.save(vegetable);
    }

    @Override
    public void delete(Vegetable vegetable) {
        vegetableRepository.delete(vegetable);
    }

    @Override
    public List<Vegetable> sortByAscPrice() {
        return vegetableRepository.sortAscByPrice();
    }

    @Override
    public List<Vegetable> sortDescByPrice() {
        return vegetableRepository.sortDescByPrice();
    }

    @Override
    public List<Vegetable> searchByName(String name) {
        return vegetableRepository.searchByName(name);
    }
}
