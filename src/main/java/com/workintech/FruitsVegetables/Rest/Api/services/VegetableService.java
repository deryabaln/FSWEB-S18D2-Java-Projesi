package com.workintech.FruitsVegetables.Rest.Api.services;

import com.workintech.FruitsVegetables.Rest.Api.entity.Vegetable;

import java.util.List;

public interface VegetableService {
    List<Vegetable> find();
    Vegetable findById(int id);
    Vegetable save(Vegetable vegetable);
    void delete(Vegetable vegetable);
    List<Vegetable> sortByAscPrice();
    List<Vegetable> sortDescByPrice();
    List<Vegetable> searchByName(String name);
}
