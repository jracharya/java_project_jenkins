package com.sd.admin.adminPortal.service;

import com.sd.admin.adminPortal.model.Merchant;
import com.sd.admin.adminPortal.model.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

public interface AdminPortalConsumerService {

    public Merchant findMerchantByMobNO(String mobNo);

    Product saveProduct(Product product);

    public boolean updateLocation(String location);
}
