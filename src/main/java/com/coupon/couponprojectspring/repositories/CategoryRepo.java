package com.coupon.couponprojectspring.repositories;

import com.coupon.couponprojectspring.beans.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo extends JpaRepository<Category, Integer> {

}
