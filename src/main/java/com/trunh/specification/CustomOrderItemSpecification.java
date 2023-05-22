package com.trunh.specification;


import com.trunh.entity.OrderItem;
import lombok.Data;
import lombok.NonNull;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.*;

@SuppressWarnings("serial")
@Data
public class CustomOrderItemSpecification implements Specification<OrderItem> {
    @NonNull
    private String field;

    @NonNull
    private Object value;

    @Override
    public Predicate toPredicate(Root<OrderItem> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        if (field.equalsIgnoreCase("orderId")) {
            return criteriaBuilder.equal(root.get("order").get("id"), (int)value);
        }
        return null;
    }
}
