package com.workintech.FruitsVegetables.Rest.Api.controller;

import com.workintech.FruitsVegetables.Rest.Api.entity.Vegetable;
import com.workintech.FruitsVegetables.Rest.Api.exceptions.FruitException;
import com.workintech.FruitsVegetables.Rest.Api.services.VegetableService;
import jakarta.validation.constraints.Positive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/vegetable")
@Validated
public class VegetableController {
    private VegetableService vegetableService;

    @Autowired
    public VegetableController(VegetableService vegetableService) {
        this.vegetableService = vegetableService;
    }

    @GetMapping("/")
    public List<Vegetable> get(){
        return vegetableService.find();
    }

    @GetMapping("/{id}")
    public Vegetable getById(@Positive @PathVariable int id){
        Vegetable vegetable = vegetableService.findById(id);
        if(vegetable == null){
            throw new FruitException("Vegetable with given name not exist", HttpStatus.NOT_FOUND);
        }
        return vegetable;
    }

    @GetMapping("/desc")
    public List<Vegetable> getByDesc(){
        return vegetableService.sortDescByPrice();
    }

    @PostMapping("/")
    public Vegetable save(@Validated @RequestBody Vegetable vegetable){
        return vegetableService.save(vegetable);
    }

    @PostMapping("/{name}")
    public List <Vegetable> vegetableByname(@PathVariable String name){
        return vegetableService.searchByName(name);
    }

    @PutMapping("/")
    public Vegetable update(@RequestBody Vegetable vegetable){
        return vegetableService.save(vegetable);
    }

    @DeleteMapping("/{id}")
    public Vegetable delete(@PathVariable int id){
        Vegetable vegetable = vegetableService.findById(id);
        if(vegetable == null){
            //TODO throw not found Exception
        }
        vegetableService.delete(vegetable);
        return vegetable;
    }

}
