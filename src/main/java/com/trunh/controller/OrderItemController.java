package com.trunh.controller;

import com.trunh.dto.OrderItemDTO;
import com.trunh.entity.OrderItem;
import com.trunh.form.OrderItemCreateForm;
import com.trunh.form.OrderItemUpdateForm;
import com.trunh.service.OrderItemService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

public class OrderItemController {
    @Autowired
    private OrderItemService cartItemService;
    @Autowired
    private ModelMapper modelMapper;

    @GetMapping
    public Page<OrderItemDTO> getOrderItemList(Pageable pageable, @RequestParam("orderId") int orderId) {
        Page<OrderItem> cartItemPage = cartItemService.getOrderItemList(pageable, orderId);
        List<OrderItemDTO> cartItemDTOList = modelMapper.map(cartItemPage.getContent(), new TypeToken<List<OrderItemDTO>>(){}.getType());
        return new PageImpl(cartItemDTOList, pageable, cartItemPage.getTotalElements());

    };
    @PostMapping
    public ResponseEntity<?> createOrderItem(@RequestBody @Valid OrderItemCreateForm form) {
        OrderItem cartItem = modelMapper.map(form, OrderItem.class);
        return ResponseEntity.ok().body("Add item to cart successfully");

    }
    @PutMapping
    public ResponseEntity<?> updateOrderItem(@RequestParam(name = "id") int id, @RequestBody @Valid OrderItemUpdateForm form) {
        OrderItem cartItem = modelMapper.map(form, OrderItem.class);
        cartItem.setId(id);
        cartItemService.updateOrderItem(cartItem);
        return ResponseEntity.ok().body("Update cart item succcessfully");
    }
    @DeleteMapping
    public ResponseEntity<?> deleteOrderItem(@RequestParam(name="id") int id) {
        cartItemService.deleteOrderItem(id);
        return ResponseEntity.ok().body("Deleted product successfully");
    }
    @DeleteMapping("/multiple")
    public ResponseEntity<?> deleteMultipleOrderItem(@RequestBody List<Integer> ids) {
        cartItemService.deleteMultipleOrderItems(ids);
        return ResponseEntity.ok().body("Deleted products successfully");
    }
    @DeleteMapping("/clear")
    public ResponseEntity<?> deleteAllOrderItem(@RequestParam(name="accountId") int accountId) {
        cartItemService.deleteAllOrderItems(accountId);
        return ResponseEntity.ok().body("Deleted products successfully");
    }
}
