package com.hoteats.controller;

import java.util.List;

import com.hoteats.models.Item;

public interface ItemController {

	List<Item> hotSelling();

	List<Item> fastMoving();

	List<Item> eatNow();

	List<Item> searchItems(List<String> tags);

}
