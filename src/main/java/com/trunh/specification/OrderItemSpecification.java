package com.trunh.specification;

import com.trunh.entity.OrderItem;
import org.springframework.data.jpa.domain.Specification;

public class OrderItemSpecification {
    public static Specification<OrderItem> buildWhere(int orderId){
        CustomOrderItemSpecification order = new CustomOrderItemSpecification("orderId", orderId);
        Specification<OrderItem> where=Specification.where(order);
        System.out.println(where);
        return where;
    }
}
