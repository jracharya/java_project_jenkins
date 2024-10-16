package com.sd.merchant.service;

import com.sd.merchant.model.Merchant;
import com.sd.merchant.model.MerchantProductReq;
import com.sd.merchant.model.Product;
import com.sd.merchant.model.ProductResp;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface MerchantService {

    public Merchant registerMerchant(Merchant merchant);

    public Merchant findById(Integer id);

    public Merchant findByMerchantName(String merchantName);

    public Merchant getDataByMobNo(String mobNo);

    List<Merchant> saveAllMerchant(List<Merchant> merchant);

    Merchant findByMerchantAcNo(String merchantAccountNo);

    List<Object[]> findByNameAndState(String mobNo);

    Merchant getNameAndEmail(String mobNo);

    Product saveProduct(Product product);

    ProductResp saveMerchantProductReq(MerchantProductReq merchantProductReq);
}
