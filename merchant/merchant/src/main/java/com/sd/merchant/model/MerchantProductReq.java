package com.sd.merchant.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MerchantProductReq {
    private Merchant merchant;
    private Product product;
}
