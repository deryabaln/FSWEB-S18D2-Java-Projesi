package com.workintech.FruitsVegetables.Rest.Api.services;

import com.workintech.FruitsVegetables.Rest.Api.dao.FruitRepository;
import com.workintech.FruitsVegetables.Rest.Api.entity.Fruit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class FruitServiceImpl implements FruitService {

    private FruitRepository fruitRepository;

    @Autowired
    public FruitServiceImpl(FruitRepository fruitRepository) {
        this.fruitRepository = fruitRepository;
    }

    @Override
    public List<Fruit> find() {
        return fruitRepository.findAll();
    }

    @Override
    public Fruit findById(int id) {
        Optional<Fruit> fruit = fruitRepository.findById(id);
        if(fruit.isPresent()){
            return fruit.get();
        }
        return null;
    }

    @Override
    public Fruit save(Fruit fruit) {
        return fruitRepository.save(fruit);
    }

    @Override
    public void delete(Fruit fruit) {
        fruitRepository.delete(fruit);
    }

    @Override
    public List<Fruit> sortByAscPrice() {
        return fruitRepository.sortAscByPrice();
    }

    @Override
    public List<Fruit> sortDescByPrice() {
        return fruitRepository.sortDescByPrice();
    }

    @Override
    public List<Fruit> searchByName(String name) {
        return fruitRepository.searchByName(name);
    }
}
