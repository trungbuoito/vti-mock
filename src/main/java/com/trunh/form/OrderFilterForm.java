package com.trunh.form;

import lombok.Data;
import lombok.NonNull;

import java.util.Date;
@Data
public class OrderFilterForm {
    @NonNull
    private int accountId;
    private int minCost;
    private int maxCost;
    private Date startDate;
    private Date endDate;
}
