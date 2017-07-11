package com.hoteats.service;

import java.util.List;

import com.hoteats.models.EatItem;
import com.hoteats.models.enums.ItemType;

public interface EatNowLaterService {

	List<EatItem> getItems(ItemType itemType);

	List<EatItem> addData(List<EatItem> eatItems);

}
