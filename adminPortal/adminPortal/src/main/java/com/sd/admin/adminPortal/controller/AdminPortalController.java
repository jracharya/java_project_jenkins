package com.sd.admin.adminPortal.controller;

import com.sd.admin.adminPortal.model.Merchant;
import com.sd.admin.adminPortal.model.Product;
import com.sd.admin.adminPortal.service.AdminPortalConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class AdminPortalController {

    @Autowired
    private AdminPortalConsumerService adminPortalConsumerService;

    @GetMapping("/admin/findMerchantByMobNo/{mobNo}")
    public ResponseEntity<Merchant> findMerchantByMobNO(@PathVariable String mobNo)
    {
        Merchant merchant = adminPortalConsumerService.findMerchantByMobNO(mobNo);
        return new ResponseEntity<>(merchant, HttpStatus.OK);
    }
    @PostMapping("/admin/save/product")
    public ResponseEntity<Product> saveProduct(@RequestBody Product product)
    {
        return new ResponseEntity<>(adminPortalConsumerService.saveProduct(product), HttpStatus.OK);
    }
    @PostMapping("/admin/update")
    public ResponseEntity<?> updateLocation(String location)
    {
        for(int i=1; i<=200; i++) {
            this.adminPortalConsumerService.updateLocation("( " + Math.random() * 100 + " , " + Math.random() * 100 + " )");
        }
        return new ResponseEntity<>(Map.of("message", "Location Update"), HttpStatus.OK);
    }
}
