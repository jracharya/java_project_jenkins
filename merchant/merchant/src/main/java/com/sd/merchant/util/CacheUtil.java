package com.sd.merchant.util;
import com.sd.merchant.model.Merchant;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
@Component
public class CacheUtil {

    Map<String, Merchant> map = null;
    @PostConstruct
    public void init() {
        map = new ConcurrentHashMap<>();
    }
    public boolean isKeyPresent(String key)
    {
       return map.containsKey(key);
    }
    public Merchant fetchData(String key)
    {
        return map.get(key);
    }
    public void storeData(String key,Merchant merchant)
    {
        map.put(key,merchant);
    }
}

