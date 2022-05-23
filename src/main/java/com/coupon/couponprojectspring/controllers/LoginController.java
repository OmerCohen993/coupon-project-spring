package com.coupon.couponprojectspring.controllers;

import com.coupon.couponprojectspring.beans.ClientDetails;
import com.coupon.couponprojectspring.exceptions.LoginException;
import com.coupon.couponprojectspring.services.LoginService;
import com.coupon.couponprojectspring.services.serviceImpl.AdminServiceImpl;
import com.coupon.couponprojectspring.services.serviceImpl.CompanyServiceImpl;
import com.coupon.couponprojectspring.services.serviceImpl.CustomerServiceImpl;
import com.coupon.couponprojectspring.utils.JWT;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
@RequiredArgsConstructor
public class LoginController {
    private final JWT jwt;
    private final LoginService loginService;
    private final AdminServiceImpl adminService;
    private final CompanyServiceImpl companyService;
    private final CustomerServiceImpl customerService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody ClientDetails clientDetails) throws LoginException {
        if (loginService.login(clientDetails) == null) {
            throw new LoginException(clientDetails.getClientType());
        }
        return new ResponseEntity<>(jwt.generateToken(clientDetails), HttpStatus.OK);
    }

}
