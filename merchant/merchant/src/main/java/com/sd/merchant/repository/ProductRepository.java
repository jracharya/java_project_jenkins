package com.sd.merchant.repository;

import com.sd.merchant.model.Merchant;
import com.sd.merchant.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {


}
