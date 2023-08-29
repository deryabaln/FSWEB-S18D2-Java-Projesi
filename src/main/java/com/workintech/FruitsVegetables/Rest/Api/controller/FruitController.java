package com.workintech.FruitsVegetables.Rest.Api.controller;

import com.workintech.FruitsVegetables.Rest.Api.entity.Fruit;
import com.workintech.FruitsVegetables.Rest.Api.exceptions.PlantException;
import com.workintech.FruitsVegetables.Rest.Api.services.FruitService;
import jakarta.validation.constraints.Positive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fruit")
@Validated
public class FruitController {
    private FruitService fruitService;

    @Autowired
    public FruitController(FruitService fruitService) {
        this.fruitService = fruitService;
    }

    @GetMapping("/")
    public List<Fruit> get(){
        return fruitService.find();
    }

    @GetMapping("/{id}")
    public Fruit getById(@Positive @PathVariable int id){
        Fruit fruit = fruitService.findById(id);
        if(fruit == null){
            throw new PlantException("Fruit with given id not exist", HttpStatus.NOT_FOUND);
        }
        return fruit;
    }

    @GetMapping("/desc")
    public List<Fruit> getByPriceDesc(){
        return fruitService.sortDescByPrice();
    }

    @PostMapping("/")
    public Fruit save(@Validated @RequestBody Fruit fruit){
        return fruitService.save(fruit);
    }

    @PostMapping("/{name}")
    public List <Fruit> fruiyByname(@PathVariable String name){
        return fruitService.searchByName(name);
    }

    @PutMapping("/")
    public Fruit update(@RequestBody Fruit fruit){
        return fruitService.save(fruit);
    }

    @DeleteMapping("/{id}")
    public Fruit delete(@PathVariable int id){
        Fruit fruit = fruitService.findById(id);
        if(fruit == null){
            throw new PlantException("Fruit with given id not exist", HttpStatus.NOT_FOUND);
        }
        fruitService.delete(fruit);
        return fruit;
    }


}
