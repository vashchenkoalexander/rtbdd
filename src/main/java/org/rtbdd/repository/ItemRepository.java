package org.rtbdd.repository;

import org.rtbdd.model.Item;
import org.rtbdd.model.ItemStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface ItemRepository extends JpaRepository<Item, Long> {

    List<Item> findAllByStatus(ItemStatus status);

}
