package com.nazartsyhaniuk.lincor_api.common.repository;

import com.nazartsyhaniuk.lincor_api.common.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ItemRepository extends JpaRepository<Item, UUID> {
}
