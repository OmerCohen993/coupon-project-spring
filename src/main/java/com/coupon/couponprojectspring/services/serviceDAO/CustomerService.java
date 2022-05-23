package com.coupon.couponprojectspring.services.serviceDAO;

import com.coupon.couponprojectspring.beans.Categories;
import com.coupon.couponprojectspring.beans.Coupon;
import com.coupon.couponprojectspring.beans.Customer;
import com.coupon.couponprojectspring.exceptions.AlreadyExistsException;
import com.coupon.couponprojectspring.exceptions.NotExistException;

import java.util.List;

public interface CustomerService {

    void purchaseCoupon(int couponID) throws NotExistException, AlreadyExistsException;

    List<Coupon> getAllCustomerCoupons() throws NotExistException;

    List<Coupon> getAllCustomerCouponsByCategory(Categories category) throws NotExistException;

    List<Coupon> getAllCustomerCouponsByMaxPrice(double maxPrice) throws NotExistException;

    Customer getCustomerDetails() throws NotExistException;
}
