package com.coupon.couponprojectspring.beans;

public enum Categories {
    FOOD,
    ELECTRICITY,
    RESTAURANT,
    VACATION;

    private final int value = ordinal() + 1;

    public int getValue() {
        return value;
    }

}
