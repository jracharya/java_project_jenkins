package com.sd.admin.adminPortal.model;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class Merchant {

    private int merchantId;
    private String merchantName;
    private String merchantAccountNo;
    private int age;
    private String mobNo;
    private String email;
    private String city;
    private String state;
    private int pin;

    public Merchant(String merchantName, String email) {
        this.merchantName = merchantName;
        this.email = email;
    }
}
