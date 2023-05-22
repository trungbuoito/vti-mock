package com.trunh.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.trunh.entity.Account;
import com.trunh.entity.OrderItem;
import lombok.Data;
import org.springframework.hateoas.RepresentationModel;

import java.util.Date;
import java.util.List;

@Data
public class OrderDTO extends RepresentationModel<OrderDTO>{
    private int id;
    private int totalCost;
    private String payment;
    private String address;
    private String status;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date createdAt;
    private Account account;
    private List<OrderItemDTO> orderItems;
    @Data
    public static class OrderItemDTO extends RepresentationModel<OrderItemDTO> {
        @JsonProperty("orderItemId")
        private int id;
        private String productName;
        private int price;
        private int quantity;
    }
}
