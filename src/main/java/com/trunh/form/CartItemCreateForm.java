package com.trunh.form;

import lombok.Data;


@Data
public class CartItemCreateForm {
    private int accountID;
    private int productID;
    private int quantity;
}
