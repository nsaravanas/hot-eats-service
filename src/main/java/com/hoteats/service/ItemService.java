package com.hoteats.service;

import java.util.List;

import com.hoteats.models.Item;

public interface ItemService {

	List<Item> search(List<String> tags);

	List<Item> saveAll(List<Item> sample);

}
