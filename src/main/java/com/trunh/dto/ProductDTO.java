package com.trunh.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.hateoas.RepresentationModel;

import java.util.Date;
import java.util.List;

@Data
public class ProductDTO extends RepresentationModel<ProductDTO>{
    private int id;
    private String name;
    private int price;
    private String sku;
    private int quantity;
    private String desc;
    private String gender;
    private String category;
    private String size;
    private String imageUrl;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date createdAt;
    private List<OrderItemDTO> orders;

    @Data
    public static class OrderItemDTO extends RepresentationModel<OrderItemDTO> {
        @JsonProperty("orderItemId")
        private int id;
        private String accountName;
        private int quantity;
    }
}
