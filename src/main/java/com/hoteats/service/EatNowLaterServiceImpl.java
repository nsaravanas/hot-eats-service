package com.hoteats.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hoteats.models.EatItem;
import com.hoteats.models.enums.ItemType;
import com.hoteats.repository.EatNowLaterRepository;

@Service
public class EatNowLaterServiceImpl implements EatNowLaterService {

	@Autowired
	private EatNowLaterRepository repository;

	@Override
	public List<EatItem> getItems(ItemType type) {
		return this.repository.findAllByType(type);
	}

	@Override
	public List<EatItem> addData(List<EatItem> eatItems) {
		return this.repository.save(eatItems);
	}
}
