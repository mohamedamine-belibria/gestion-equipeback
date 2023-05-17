package com.example.auth.repository;

import com.example.auth.modal.Item;
import com.example.auth.modal.ItemDependence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ItemDependenceRepository  extends JpaRepository<ItemDependence,Long> {
    @Query(
            value = "SELECT * FROM item_dependence itd where itd.id_first_item = :projectId ",
            nativeQuery = true)
    List<ItemDependence> findAllTasksProject(@Param("projectId") Long projectId);
    Optional<ItemDependence> findBySecondItem(Item taskId);
}
