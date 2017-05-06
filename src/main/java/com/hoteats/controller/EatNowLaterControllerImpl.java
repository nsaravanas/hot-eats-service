package com.hoteats.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hoteats.commons.CommonStubs;
import com.hoteats.models.EatItem;
import com.hoteats.models.enums.ItemType;
import com.hoteats.service.EatNowLaterService;

@RestController
@RequestMapping("/eats")
public class EatNowLaterControllerImpl implements EatNowLaterController {

	@Autowired
	private EatNowLaterService service;

	@Override
	@RequestMapping(value = "/eatnow", method = RequestMethod.GET)
	public List<EatItem> getEatNowItems() {
		return this.service.getItems(ItemType.EAT_NOW);
	}

	@Override
	@RequestMapping(value = "/eatlater", method = RequestMethod.GET)
	public List<EatItem> getEatLaterItems() {
		return this.service.getItems(ItemType.EAT_LATER);
	}

	@RequestMapping(value = "/load", method = RequestMethod.GET)
	public List<EatItem> loadSampleData() {
		return this.service.addData(CommonStubs.eatItems());
	}

}
