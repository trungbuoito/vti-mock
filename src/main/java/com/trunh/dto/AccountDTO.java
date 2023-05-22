package com.trunh.dto;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.hateoas.RepresentationModel;

import java.util.Date;
import java.util.List;

@Data
public class AccountDTO extends RepresentationModel<AccountDTO> {
	private int id;
	private String username;
	private String password;
	private String firstName;
	private String lastName;
	private String email;
	private String role;
	private String status;
	private String avatarUrl;
	List<CartItemDTO> cartItems;
	List<OrderDTO> orders;
	@Data
	public static class CartItemDTO extends RepresentationModel<CartItemDTO> {
		@JsonProperty("cartItemId")
		private int id;
		private String productName;
		private int quantity;
	}
	@Data
	public static class OrderDTO extends RepresentationModel<OrderDTO> {
		@JsonProperty("orderId")
		private int id;
		private int totalCost;
		private String payment;
		private String address;
		private String status;
		@JsonFormat(pattern = "dd-MM-yyyy")
		private Date createdAt;
	}
	
}
