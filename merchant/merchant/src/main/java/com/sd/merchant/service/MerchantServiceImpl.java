package com.sd.merchant.service;

import com.sd.merchant.Exception.InvalidApiException;
import com.sd.merchant.Exception.InvalidMerchantDataException;
import com.sd.merchant.model.Merchant;
import com.sd.merchant.model.MerchantProductReq;
import com.sd.merchant.model.Product;
import com.sd.merchant.model.ProductResp;
import com.sd.merchant.repository.MerchantRepository;
import com.sd.merchant.repository.ProductRepository;
import com.sd.merchant.util.CacheUtil;
import com.sd.merchant.validator.Validate;
import org.aspectj.lang.annotation.AfterThrowing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MerchantServiceImpl implements MerchantService{

    @Autowired
    private MerchantRepository merchantRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CacheUtil cacheUtil ;

    @Override
    public Merchant registerMerchant(Merchant merchant) {
        merchant.setMerchantAccountNo(randomNo());
        Merchant merchantResp = merchantRepository.save(merchant);
        return merchantResp;
    }
    @Override
    public Merchant findById(Integer id) {
        return merchantRepository.findById(id).get();
    }
    @Override
    public Merchant findByMerchantName(String merchantName) {
        return merchantRepository.findByMerchantName(merchantName);
    }
    @Override
    public Merchant getDataByMobNo(String mobNo) {

                 return merchantRepository.getDataByMobNo(mobNo);
    }
    @Override
    public List<Merchant> saveAllMerchant(List<Merchant> merchant) {

//        for (Merchant merchantAc : merchant)
//            merchantAc.setMerchantAccountNo(generateAcNo());
//        merchant.stream().forEach(merchantAc -> merchantAc.setMerchantAccountNo(generateAcNo()));
        return merchantRepository.saveAll(merchant.stream()
                .peek(merchantAc -> merchantAc.setMerchantAccountNo(randomNo())).collect(Collectors.toList()));
    }
    @Override
    public Merchant findByMerchantAcNo(String merchantAccountNo) {
        Merchant merchant = merchantRepository.findByMerchantAcNo(merchantAccountNo);
        if (merchant == null) {
            throw new InvalidMerchantDataException("Merchant with account number not found...");
        }

        return merchant;
    }
    @Override
    public List<Object[]> findByNameAndState(String mobNo) {
        return merchantRepository.findByNameAndState(mobNo);
    }
    @Override
    public Merchant getNameAndEmail(String mobNo) {
        return merchantRepository.getNameAndEmail(mobNo);
    }
    @Override
    public Product saveProduct(Product product) {
        product.setProductCode(randomNo());
        return productRepository.save(product);
    }
   // @Transactional
    @Override
    public ProductResp saveMerchantProductReq(MerchantProductReq merchantProductReq) {
        Merchant merchant = merchantProductReq.getMerchant();
        Product product = merchantProductReq.getProduct();

        merchant.setMerchantAccountNo(randomNo());
        Merchant savedMerchant = merchantRepository.save(merchant);

        Product savedProduct = null;
        Validate validator = new Validate();
        if(validator.isValidate(product))
        {
            product.setProductCode(randomNo());
            savedProduct = productRepository.save(product);
        }
        else {
            throw new InvalidApiException("Error Message: InvaidException: please add valid product catagory");
        }

        return ProductResp.builder()
                .merchantName(savedMerchant.getMerchantName())
                .productName(savedProduct.getProductName())
                .productCode(savedProduct.getProductCode())
                .build();
    }

    private String randomNo()
    {
        Double randomNum = Math.random();
        String randomNo = randomNum.toString().substring(2);
        return randomNo;
    }


}
