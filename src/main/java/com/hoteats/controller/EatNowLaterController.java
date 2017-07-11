package com.hoteats.controller;

import java.util.List;

import com.hoteats.models.EatItem;

public interface EatNowLaterController {

	List<EatItem> getEatNowItems();

	List<EatItem> getEatLaterItems();

}
