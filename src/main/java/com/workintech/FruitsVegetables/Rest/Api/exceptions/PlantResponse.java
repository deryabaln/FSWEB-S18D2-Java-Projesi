package com.workintech.FruitsVegetables.Rest.Api.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlantResponse {
    private int status;
    private String message;
    private long timestamp;
}
