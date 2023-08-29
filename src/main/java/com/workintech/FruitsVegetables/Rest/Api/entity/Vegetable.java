package com.workintech.FruitsVegetables.Rest.Api.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "vegetable", schema = "spring")
public class Vegetable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @NotNull
    @NotBlank
    @Column(name = "name")
    private String name;

    @Column(name = "price")
    @DecimalMin("20")
    private double price;

    @Column(name = "is_grownon_tree")
    private boolean isGrownOnTree;
}
