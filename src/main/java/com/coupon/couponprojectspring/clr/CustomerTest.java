package com.coupon.couponprojectspring.clr;

import com.coupon.couponprojectspring.beans.Categories;
import com.coupon.couponprojectspring.beans.ClientDetails;
import com.coupon.couponprojectspring.beans.ClientType;
import com.coupon.couponprojectspring.services.LoginService;
import com.coupon.couponprojectspring.services.serviceImpl.CustomerServiceImpl;
import com.coupon.couponprojectspring.utils.TablePrinter;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Order(3)
public class CustomerTest implements CommandLineRunner {
    private final LoginService loginService;

    @Override
    public void run(String... args) throws Exception {
        CustomerServiceImpl customerService = (CustomerServiceImpl) loginService.login(
                new ClientDetails("orenlevi6@gmail.com", "orenOren", ClientType.CUSTOMER));

        System.out.println("Purchase coupon");
        customerService.purchaseCoupon(1);
        TablePrinter.print(customerService.getAllCustomerCoupons());

        System.out.println("Get coupons by category - FOOD");
        TablePrinter.print(customerService.getAllCustomerCouponsByCategory(Categories.FOOD));

        System.out.println("Get coupons by max price - 50");
        TablePrinter.print(customerService.getAllCustomerCouponsByMaxPrice(50));

        System.out.println("Get customer #1 details");
//        TablePrinter.print(customerService.getCustomerDetails()); doesn't work - failed to lazily initialize
        System.out.println(customerService.getCustomerDetails());
    }

}
