package com.sd.merchant.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductResp {

    private String productName;
    private String productCode;
    private String merchantName;

}
