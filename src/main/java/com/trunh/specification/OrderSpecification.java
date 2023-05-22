package com.trunh.specification;

import com.trunh.entity.Order;
import com.trunh.form.OrderFilterForm;
import org.springframework.data.jpa.domain.Specification;

public class OrderSpecification {
    public static Specification<Order> buildWhere(OrderFilterForm oFF){
        Specification<Order> where=null;

        if (oFF != null) {
            CustomOrderSpecification accountId = new CustomOrderSpecification("accountId", oFF.getAccountId());
            if (where == null) where = accountId;
            else where = where.and(accountId);
        }

        if (oFF != null && oFF.getMinCost() > 0) {
            CustomOrderSpecification minCost = new CustomOrderSpecification("minCost", oFF.getMinCost());
            if (where == null) where = minCost;
            else where = where.and(minCost);
        }

        if (oFF != null && oFF.getMaxCost() > 0) {
            CustomOrderSpecification maxCost = new CustomOrderSpecification("maxCost", oFF.getMaxCost());
            if (where == null) where = maxCost;
            else where = where.and(maxCost);
        }

        if (oFF != null && oFF.getStartDate() != null) {
            CustomOrderSpecification minDate = new CustomOrderSpecification("minDate", oFF.getStartDate());
            if (where == null) where = minDate;
            else where = where.and(minDate);
        }

        if (oFF != null && oFF.getEndDate() != null) {
            CustomOrderSpecification maxDate = new CustomOrderSpecification("maxDate", oFF.getEndDate());
            if (where == null) where = maxDate;
            else where = where.and(maxDate);
        }
        System.out.println(where);
        return where;
    }
}
