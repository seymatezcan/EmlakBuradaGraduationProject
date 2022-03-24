package com.EmlakBurada.repository;

import com.EmlakBurada.model.AdvertPocket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AdvertPocketRepository extends JpaRepository<AdvertPocket,Integer> {

    @Query(value = "SELECT * FROM Advert_Pocket WHERE enrollee_id=?1", nativeQuery = true)
    AdvertPocket findByEnrolleeId(int enrolleeId);
}
