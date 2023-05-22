package com.trunh.specification;

import com.trunh.entity.CartItem;
import org.springframework.data.jpa.domain.Specification;

public class CartItemSpecification {
    public static Specification<CartItem> buildWhere(int accountId){
        CustomCartItemSpecification account = new CustomCartItemSpecification("accountId", accountId);
        Specification<CartItem> where = Specification.where(account);
        System.out.println(where);
        return where;
    }
}
