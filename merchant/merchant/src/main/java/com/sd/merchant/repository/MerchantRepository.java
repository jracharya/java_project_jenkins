package com.sd.merchant.repository;

import com.sd.merchant.model.Merchant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MerchantRepository extends JpaRepository<Merchant, Integer> {

    public Merchant findByMerchantName(String merchantName);

    @Query(value = "SELECT * FROM Merchant WHERE mob_no = :mobNo", nativeQuery = true)
    public Merchant getDataByMobNo(@Param("mobNo") String mobNo);

    @Query("SELECT m FROM Merchant m WHERE m.merchantAccountNo = :merchantAccountNo")
    Merchant findByMerchantAcNo(@Param("merchantAccountNo") String merchantAccountNo);

    @Query("SELECT m.merchantName, m.state FROM Merchant m WHERE m.mobNo = :mobNo")
    List<Object[]> findByNameAndState(@Param("mobNo") String mobNo);

    @Query("SELECT new Merchant(m.merchantName, m.email) FROM Merchant m WHERE m.mobNo = :mobNo")
    Merchant getNameAndEmail(@Param("mobNo") String mobNo);
}
 