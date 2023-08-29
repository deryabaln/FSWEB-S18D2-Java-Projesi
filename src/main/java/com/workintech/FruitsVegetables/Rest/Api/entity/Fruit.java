package com.workintech.FruitsVegetables.Rest.Api.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "fruit", schema = "spring")
public class Fruit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @NotNull
    @NotBlank
    @Size(min =2, max=45, message ="name size must be between 2 to 45")
    @Column(name = "name")
    private String name;

    @Column(name = "price")
    @DecimalMin("20")
    private double price;

    @Enumerated(EnumType.STRING)
    @Column(name = "fruit_type")
    private FruitType FruitType;
}
