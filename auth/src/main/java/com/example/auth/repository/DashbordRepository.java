package com.example.auth.repository;

import com.example.auth.modal.Dashbord;
import com.example.auth.modal.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DashbordRepository  extends JpaRepository<Dashbord,Long> {


    @Query(value =
            "SELECT * FROM dashbord da, item it WHERE da.item_id = :itemId AND da.item_id=it.id ;", nativeQuery = true)
    Dashbord findByItemId(@Param("itemId") Long itemId);

    @Query(value =
            "SELECT * FROM dashbord da, item it WHERE da.responsable_id = :userId and it.item_type=:itemType AND da.item_id=it.id ;", nativeQuery = true)
    List<Dashbord> findDashbordsByResponsableAndItemType(Long userId, String itemType);
    @Query(value =
            "SELECT * FROM dashbord da, item it WHERE da.created_by_id = :userId  AND da.item_id=it.id ;", nativeQuery = true)
    List<Dashbord> findDashbordsByUser(Long userId);
}

