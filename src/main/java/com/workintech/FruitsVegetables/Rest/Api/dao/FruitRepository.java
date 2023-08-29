package com.workintech.FruitsVegetables.Rest.Api.dao;

import com.workintech.FruitsVegetables.Rest.Api.entity.Fruit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FruitRepository extends JpaRepository <Fruit, Integer> {
    @Query(value = "SELECT f FROM Fruit f ORDER BY f.price asc")
    public List<Fruit> sortAscByPrice();
    @Query(value = "SELECT f FROM Fruit f ORDER BY f.price desc")
    public List<Fruit> sortDescByPrice();
    @Query("SELECT f FROM Fruit f WHERE f.name ilike %:name%")
    List<Fruit> searchByName(String name);

}
