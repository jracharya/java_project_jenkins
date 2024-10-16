package com.sd.admin.adminPortal.model;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    private int productId;
    private String productName;
    private String productCode;
    private String productCategory;
    private String brand;
    private String color;
    private String description;
}
