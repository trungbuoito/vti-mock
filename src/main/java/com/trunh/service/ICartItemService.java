package com.trunh.service;

import com.trunh.entity.CartItem;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICartItemService {
    CartItem getCartItemById(int id);
    Page<CartItem> getCartItemList(Pageable pageable, int accountId);
    void createCartItem(CartItem cartItem);
    void updateCartItem(CartItem cartItem);
    void deleteCartItem(int id);
    void deleteMultipleCartItems(List<Integer> ids);
    void deleteAllCartItems(Integer accountId);

}
