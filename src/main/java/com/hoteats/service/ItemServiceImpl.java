package com.hoteats.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hoteats.models.Item;
import com.hoteats.repository.ItemRepository;

@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	private ItemRepository repository;

	@Override
	@Transactional
	public List<Item> search(List<String> tags) {
		return repository.findAllByTagsIn(tags);
	}

	@Override
	@Transactional
	public List<Item> saveAll(List<Item> items) {
		return this.repository.save(items);
	}

}
