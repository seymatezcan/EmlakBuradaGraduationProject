package com.EmlakBurada.repository;

import com.EmlakBurada.model.Advert;
import com.EmlakBurada.model.AdvertPocket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

public interface AdvertRepository extends JpaRepository<Advert,Integer> {

    @Query(value = "SELECT * FROM Advert WHERE enrollee_id=?1 AND advert_status=AdvertStatus.ACTIVE", nativeQuery = true)
    Advert findActivesByEnrolleeId(int enrolleeId);

    @Query(value = "SELECT * FROM Advert WHERE enrollee_id=?1 AND advert_status=AdvertStatus.PASSIVE", nativeQuery = true)
    Advert findPassivesByEnrolleeId(int enrolleeId);

}
