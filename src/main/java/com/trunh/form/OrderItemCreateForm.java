package com.trunh.form;

import lombok.Data;

@Data
public class OrderItemCreateForm {
    private int orderId;
    private int productId;
    private int price;
    private int quantity;
}
