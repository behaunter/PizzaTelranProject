package com.telran.api.dto;

import lombok.*;

import java.util.ArrayList;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
@ToString
public class CafeDto {

    public int id;
    public String name;
    public String city;
    public String address;
    public String email;
    public String phone;
    public String open;
    public String close;
    public ArrayList<PizzaDto> pizzaMenu;
}
