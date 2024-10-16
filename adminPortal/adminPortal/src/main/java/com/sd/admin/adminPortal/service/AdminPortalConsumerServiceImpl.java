package com.sd.admin.adminPortal.service;

import com.sd.admin.adminPortal.model.Merchant;
import com.sd.admin.adminPortal.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import static com.sd.admin.adminPortal.constant.Kafka_Constants.LOCATION_TOPIC_NAME;

@Service
public class    AdminPortalConsumerServiceImpl implements AdminPortalConsumerService{

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;
    @Value("${merchant.url.findByMob}")
    private String findUrl;

    @Override
    public Merchant findMerchantByMobNO(String mobNo) {

        ResponseEntity<Merchant> responseEntity = restTemplate
                .exchange( findUrl+ mobNo, HttpMethod.GET, null, Merchant.class);
        Merchant merchant = responseEntity.getBody();
        System.out.println("Merchant City: "+merchant.getCity());
        return merchant;

    }

    @Override
    public Product saveProduct(Product product) {
        HttpEntity<Product> requestEntity = new HttpEntity<>(product);

//        ResponseEntity<Product> responseEntity = restTemplate
//                .exchange("http://localhost:8080/merchant/save/product"
//                , HttpMethod.POST, requestEntity, Product.class);

//        ResponseEntity<Product> responseEntity = restTemplate
//                .postForEntity("http://localhost:8080/merchant/save/product"
//                        , requestEntity, Product.class);

        Product productResp = restTemplate
                .postForObject("http://localhost:8080/merchant/save/product"
                        , requestEntity, Product.class);
        return productResp;
    }

    @Override
    public boolean updateLocation(String location) {

        this.kafkaTemplate.send(LOCATION_TOPIC_NAME, location);
        System.out.println("Message produced");
        return true;
    }
}
