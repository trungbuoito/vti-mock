package com.trunh.service;

import com.trunh.entity.CartItem;
import com.trunh.repository.ICartItemRepository;
import com.trunh.specification.CartItemSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartItemService implements ICartItemService{
    @Autowired
    private ICartItemRepository cartItemRepository;
    @Override
    public CartItem getCartItemById(int id) {
        return cartItemRepository.findById(id).get();
    };
    @Override
    public Page<CartItem> getCartItemList(Pageable pageable, int accountId) {
        Specification<CartItem> where = CartItemSpecification.buildWhere(accountId);
        return cartItemRepository.findAll(where, pageable);
    };
    @Override
    public void createCartItem(CartItem cartItem) {
        cartItemRepository.save(cartItem);
    };
    @Override
    public void updateCartItem(CartItem cartItem){
        cartItemRepository.save(cartItem);
    };
    @Override
    public void deleteCartItem(int id) {
        cartItemRepository.deleteById(id);
    };
    @Override
    public void deleteMultipleCartItems(List<Integer> ids) {
        cartItemRepository.deleteMultiCartItem(ids);
    };
    @Override
    public void deleteAllCartItems(Integer accountId) {cartItemRepository.deleteAllCartItem(accountId);};
}
