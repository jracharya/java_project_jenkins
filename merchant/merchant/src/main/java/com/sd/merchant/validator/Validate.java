package com.sd.merchant.validator;

import com.sd.merchant.model.Product;

public class Validate {

    public boolean isValidate(Product product)
    {
        return product.getProductCategory().equalsIgnoreCase("Electronics Device");
    }
}
