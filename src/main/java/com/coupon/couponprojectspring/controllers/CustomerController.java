package com.coupon.couponprojectspring.controllers;

import com.coupon.couponprojectspring.beans.Categories;
import com.coupon.couponprojectspring.beans.ClientType;
import com.coupon.couponprojectspring.exceptions.AlreadyExistsException;
import com.coupon.couponprojectspring.exceptions.LoginException;
import com.coupon.couponprojectspring.exceptions.NotExistException;
import com.coupon.couponprojectspring.exceptions.TokenException;
import com.coupon.couponprojectspring.services.serviceImpl.CustomerServiceImpl;
import com.coupon.couponprojectspring.utils.JWT;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
@RequiredArgsConstructor
public class CustomerController {
    private final JWT jwt;
    private final CustomerServiceImpl customerService;

    @PostMapping("/purchase")
    public ResponseEntity<?> purchaseCoupon(@RequestHeader(name = "Authorization") String token, @RequestHeader int couponID) throws TokenException, LoginException, NotExistException, AlreadyExistsException {
        jwt.checkUser(token, ClientType.CUSTOMER);

        customerService.purchaseCoupon(couponID);

        return ResponseEntity.ok()
                .header("Authorization", jwt.generateToken(token))
                .body("Coupon #" + couponID + " purchased successfully");
    }

    @GetMapping("/coupon/get/all")
    public ResponseEntity<?> getCustomerCoupons(@RequestHeader(name = "Authorization") String token) throws NotExistException, TokenException, LoginException {
        jwt.checkUser(token, ClientType.CUSTOMER);

        return ResponseEntity.ok()
                .header("Authorization", jwt.generateToken(token))
                .body(customerService.getAllCustomerCoupons());
    }

    @GetMapping("/coupon/get/category")
    public ResponseEntity<?> getCustomerCouponsByCategory(@RequestHeader(name = "Authorization") String token, @RequestHeader Categories category) throws NotExistException, TokenException, LoginException {
        jwt.checkUser(token, ClientType.CUSTOMER);

        return ResponseEntity.ok()
                .header("Authorization", jwt.generateToken(token))
                .body(customerService.getAllCustomerCouponsByCategory(category));
    }

    @GetMapping("/coupon/get/maxPrice")
    public ResponseEntity<?> getCustomerCouponsByMaxPrice(@RequestHeader(name = "Authorization") String token, @RequestHeader double maxPrice) throws NotExistException, TokenException, LoginException {
        jwt.checkUser(token, ClientType.CUSTOMER);

        return ResponseEntity.ok()
                .header("Authorization", jwt.generateToken(token))
                .body(customerService.getAllCustomerCouponsByMaxPrice(maxPrice));
    }

    @GetMapping("/details")
    public ResponseEntity<?> getCustomerDetails(@RequestHeader(name = "Authorization") String token) throws TokenException, LoginException, NotExistException {
        jwt.checkUser(token, ClientType.CUSTOMER);

        return ResponseEntity.ok()
                .header("Authorization", jwt.generateToken(token))
                .body(customerService.getCustomerDetails());
    }

}
