package com.workintech.FruitsVegetables.Rest.Api.services;

import com.workintech.FruitsVegetables.Rest.Api.entity.Fruit;

import java.util.List;

public interface FruitService {
    List<Fruit> find();
    Fruit findById(int id);
    Fruit save(Fruit fruit);
    void delete(Fruit fruit);
    List<Fruit> sortByAscPrice();
    List<Fruit> sortDescByPrice();
    List<Fruit> searchByName(String name);
}
