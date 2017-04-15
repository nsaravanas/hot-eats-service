package com.hoteats.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hoteats.commons.CommonStubs;
import com.hoteats.models.Item;
import com.hoteats.service.ItemService;

@RestController
@RequestMapping("/items")
public class ItemControllerImpl implements ItemController {

	@Autowired
	private ItemService itemService;

	@Override
	@RequestMapping(value = "/hot", method = RequestMethod.GET)
	public List<Item> hotSelling() {
		final String query = "hot";
		return this.itemService.search(Arrays.asList(query));
	}

	@Override
	@RequestMapping(value = "/fast", method = RequestMethod.GET)
	public List<Item> fastMoving() {
		final String query = "fast";
		return this.itemService.search(Arrays.asList(query));
	}

	@Override
	@RequestMapping(value = "/eatnow", method = RequestMethod.GET)
	public List<Item> eatNow() {
		final String query = "eatnow";
		return this.itemService.search(Arrays.asList(query));
	}

	@Override
	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public List<Item> searchItems(@RequestBody List<String> tags) {
		return this.itemService.search(tags);
	}

	@RequestMapping(value = "/sample", method = RequestMethod.GET)
	public List<Item> sample() {
		return CommonStubs.items();
	}

}
