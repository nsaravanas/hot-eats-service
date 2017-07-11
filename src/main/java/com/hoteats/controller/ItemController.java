package com.hoteats.controller;

import java.util.List;

import com.hoteats.models.Item;

public interface ItemController {

	List<Item> searchItems(List<String> tags);

}
