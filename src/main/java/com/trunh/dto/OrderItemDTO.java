package com.trunh.dto;

import lombok.Data;
import org.springframework.hateoas.RepresentationModel;

@Data
public class OrderItemDTO extends RepresentationModel<OrderItemDTO> {
    private int id;
    private int orderId;
    private int productId;
    private int price;
    private int quantity;
}
