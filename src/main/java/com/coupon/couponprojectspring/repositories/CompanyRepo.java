package com.coupon.couponprojectspring.repositories;

import com.coupon.couponprojectspring.beans.Company;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CompanyRepo extends JpaRepository<Company, Integer> {

    boolean existsByIdAndName(int id, String name);

    Optional<Company> findByEmailAndPassword(String email, String password);
}
