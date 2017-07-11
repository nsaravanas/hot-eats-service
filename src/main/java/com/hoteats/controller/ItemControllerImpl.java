package com.hoteats.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hoteats.models.Item;
import com.hoteats.service.ItemService;

@RestController
@RequestMapping("/items")
public class ItemControllerImpl implements ItemController {

	@Autowired
	private ItemService service;

	@Override
	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public List<Item> searchItems(@RequestBody List<String> tags) {
		return this.service.search(tags);
	}

}
