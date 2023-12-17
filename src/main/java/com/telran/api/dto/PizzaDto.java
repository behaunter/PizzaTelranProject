package com.telran.api.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
@ToString
public class PizzaDto {
    public int id;
    public String name;
    public String size;
    public String keyIngredients;
    public double price;
    public String image;
}
