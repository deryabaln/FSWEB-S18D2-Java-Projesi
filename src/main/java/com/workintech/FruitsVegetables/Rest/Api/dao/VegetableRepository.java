package com.workintech.FruitsVegetables.Rest.Api.dao;

import com.workintech.FruitsVegetables.Rest.Api.entity.Vegetable;
import jakarta.persistence.TypedQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface VegetableRepository extends JpaRepository<Vegetable, Integer> {
    @Query(value = "SELECT v FROM Vegetable v ORDER BY v.price asc")
    public List<Vegetable> sortAscByPrice();
    @Query(value = "SELECT v FROM Vegetable v ORDER BY v.price desc")
    public List<Vegetable> sortDescByPrice();
    @Query("SELECT v FROM Vegetable v WHERE v.name ilike %:name%")
    List<Vegetable> searchByName(String name);


}
