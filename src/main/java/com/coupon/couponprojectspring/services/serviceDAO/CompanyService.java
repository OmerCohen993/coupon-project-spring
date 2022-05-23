package com.coupon.couponprojectspring.services.serviceDAO;

import com.coupon.couponprojectspring.beans.Categories;
import com.coupon.couponprojectspring.beans.Company;
import com.coupon.couponprojectspring.beans.Coupon;
import com.coupon.couponprojectspring.exceptions.NotExistException;

import java.util.List;

public interface CompanyService {

    void addCoupon(Coupon coupon) throws NotExistException;

    void updateCoupon(Coupon coupon) throws NotExistException;

    void deleteCoupon(int couponID) throws NotExistException;

    List<Coupon> getAllCompanyCoupons() throws NotExistException;

    List<Coupon> getAllCompanyCouponsByCategory(Categories category) throws NotExistException;

    List<Coupon> getAllCompanyCouponsByMaxPrice(double maxPrice) throws NotExistException;

    Company getCompanyDetails() throws NotExistException;
}
