package com.sd.merchant.controller;
import com.sd.merchant.model.Merchant;
import com.sd.merchant.model.MerchantProductReq;
import com.sd.merchant.model.Product;
import com.sd.merchant.model.ProductResp;
import com.sd.merchant.service.MerchantService;
import com.sun.net.httpserver.HttpServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/merchant")
@RestController
public class MerchantController {

    @Autowired
    private MerchantService merchantService;

    @PostMapping("/register")
    public ResponseEntity<Merchant> registerMerchant(@RequestBody Merchant merchant) {
        Merchant merchantResp = merchantService.registerMerchant(merchant);
        return new ResponseEntity<>(merchantResp, HttpStatus.OK);
    }
    @GetMapping("/findById/{id}")
    public ResponseEntity<Merchant> findById(@PathVariable Integer id) {
        Merchant merchantResp = merchantService.findById(id);
        return new ResponseEntity<>(merchantResp, HttpStatus.OK);
    }
    @GetMapping("/findByName/{merchantName}")
    public ResponseEntity<Merchant> findByMerchantName(@PathVariable String merchantName) {
        Merchant merchantResp = merchantService.findByMerchantName(merchantName);
        return new ResponseEntity<>(merchantResp, HttpStatus.OK);
    }
    @GetMapping("/findByMob/{mobNo}")
    public ResponseEntity<Merchant> getDataByMobNo(@PathVariable String mobNo) {
        Merchant merchantResp = merchantService.getDataByMobNo(mobNo);
        return new ResponseEntity<>(merchantResp, HttpStatus.OK);
    }
    @PostMapping("/saveAllMerchant")
    public ResponseEntity<List<Merchant>> saveAllMerchant(@RequestBody List<Merchant> merchant) {
        List<Merchant> savedMerchant = merchantService.saveAllMerchant(merchant);
        return new ResponseEntity<>(savedMerchant, HttpStatus.OK);
    }
    @GetMapping("/findByMerchantAcNo/{merchantAccountNo}")
    public ResponseEntity<Merchant> findByMerchantAcNo(@PathVariable String merchantAccountNo) {
        Merchant merchantResp = merchantService.findByMerchantAcNo(merchantAccountNo);
        return new ResponseEntity<>(merchantResp, HttpStatus.OK);
    }
    @GetMapping("/findByNameAndState/{mobNo}")
    public ResponseEntity<List<Object[]>> findByNameAndState(@PathVariable String mobNo)
    {
        List<Object[]> listOfNameAndAdd = merchantService.findByNameAndState(mobNo);
        return new ResponseEntity<>(listOfNameAndAdd, HttpStatus.OK);
    }
    @GetMapping("/getNameAndEmail/{mobNo}")
    public ResponseEntity<Merchant> getNameAndEmail(@PathVariable String mobNo) {
        Merchant merchants = merchantService.getNameAndEmail(mobNo);
        return new ResponseEntity<>(merchants, HttpStatus.OK);
    }
    @GetMapping("/test")
    public Merchant test() {
        Merchant merchant = new Merchant();
        merchant.setMerchantAccountNo("123");
        return merchant;
    }
    @PostMapping("/save/product")
    public ResponseEntity<Product> saveProduct(@RequestBody Product product)
    {
        Product product1 =  merchantService.saveProduct(product);
        return new ResponseEntity<>(product1, HttpStatus.OK);
    }
    @PostMapping("/saveMerchantProductReq")
    public ResponseEntity<?> saveMerchantProductReq(@RequestBody MerchantProductReq merchantProductReq)
    {
        ProductResp productResp = merchantService.saveMerchantProductReq(merchantProductReq);
        return new ResponseEntity<>(productResp, HttpStatus.OK);
    }
    @GetMapping("/test1")
    public MerchantProductReq test1()
    {
       Merchant merchant = Merchant.builder().merchantId(123).build();
       Product product = Product.builder().productId(456).build();
        return MerchantProductReq.builder()
                .merchant(merchant)
                .product(product)
                .build();
    }
    @GetMapping("/test2")
    public Product test2() {
        Product product = Product.builder().productId(123).build();
        return product;
    }

}
