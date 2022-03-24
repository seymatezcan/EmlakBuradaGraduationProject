package com.AdvertStatus.repository;

import com.AdvertStatus.model.Advert;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface AdvertRepository extends JpaRepository<Advert,Integer> {

    @Transactional
    @Modifying(flushAutomatically = true)
    @Query(value = "UPDATE Advert SET advert_status=?,advert_title=?,category=? WHERE enrollee_id=?,advert_id=?", nativeQuery = true)
    void updateAdvertStatus(Advert advert);
}
