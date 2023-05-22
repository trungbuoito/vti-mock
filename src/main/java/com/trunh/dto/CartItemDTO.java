package com.trunh.dto;


import lombok.Data;
import org.springframework.hateoas.RepresentationModel;

@Data
public class CartItemDTO extends RepresentationModel<CartItemDTO> {
    private int id;
    private int accountID;
    private int productID;
    private int quantity;
}
