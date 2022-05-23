package com.coupon.couponprojectspring.services;

import com.coupon.couponprojectspring.repositories.CategoryRepo;
import com.coupon.couponprojectspring.repositories.CompanyRepo;
import com.coupon.couponprojectspring.repositories.CouponRepo;
import com.coupon.couponprojectspring.repositories.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class ClientService {
    @Autowired
    protected CategoryRepo categoryRepo;

    @Autowired
    protected CompanyRepo companyRepo;

    @Autowired
    protected CustomerRepo customerRepo;

    @Autowired
    protected CouponRepo couponRepo;

    public abstract boolean login(String email, String password);
}
