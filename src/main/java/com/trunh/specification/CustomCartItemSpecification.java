package com.trunh.specification;

import com.trunh.entity.CartItem;
import lombok.Data;
import lombok.NonNull;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
@SuppressWarnings("serial")
@Data
public class CustomCartItemSpecification implements Specification<CartItem> {
    @NonNull
    private String field;

    @NonNull
    private Object value;

    @Override
    public Predicate toPredicate(Root<CartItem> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        if (field.equalsIgnoreCase("accountId")) {
            return criteriaBuilder.equal(root.get("account").get("id"), (int)value);
        }
        return null;
    }
}
