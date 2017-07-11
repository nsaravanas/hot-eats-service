package com.hoteats.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hoteats.models.EatItem;
import com.hoteats.models.enums.ItemType;

@Repository
public interface EatNowLaterRepository extends JpaRepository<EatItem, Long> {
	List<EatItem> findAllByType(ItemType type);
}
