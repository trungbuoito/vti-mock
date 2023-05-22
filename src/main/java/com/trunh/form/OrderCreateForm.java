package com.trunh.form;

import com.trunh.entity.Account;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class OrderCreateForm {
    @NotBlank(message = "Payment method cannot be blank")
    private String payment;

    private String address;

    private String status;

    private int accountId;
}
