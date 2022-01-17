package com.naekang.orderdemo.repository;

import com.naekang.orderdemo.entity.ItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ItemRepository extends JpaRepository<ItemEntity, Long> {

    public Optional<ItemEntity> findById(Long itemId);

}
