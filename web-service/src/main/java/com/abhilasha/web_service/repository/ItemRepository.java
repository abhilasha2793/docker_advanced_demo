package com.abhilasha.web_service.repository;


import com.abhilasha.web_service.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item,Long> {
}
