package com.hoteats.commons;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.hoteats.models.Address;
import com.hoteats.models.Coordinate;
import com.hoteats.models.Delivery;
import com.hoteats.models.Item;
import com.hoteats.models.Menu;
import com.hoteats.models.Order;
import com.hoteats.models.OrderItem;
import com.hoteats.models.OrderPrice;
import com.hoteats.models.Restaurant;
import com.hoteats.models.RestaurantAddress;
import com.hoteats.models.TimeCoorinate;
import com.hoteats.models.Track;
import com.hoteats.models.User;
import com.hoteats.models.UserAddress;
import com.hoteats.models.enums.Category;
import com.hoteats.models.enums.ModeOfPay;
import com.hoteats.models.enums.Status;

public class CommonStubs {

	private CommonStubs() {
		throw new AssertionError("Can't instantiate");
	}

	public static Restaurant testRestaurant() {
		Restaurant r = new Restaurant();
		r.setName("Test Restaurant");
		r.setRestaurantId(100L);
		List<Menu> menu = new ArrayList<>();
		Menu m1 = new Menu();
		m1.setId(10L);
		m1.setRestaurant(r);
		List<Item> items = new ArrayList<>();
		Item i1 = new Item();
		i1.setCategory(Category.BREAKFAST);
		i1.setItemId(1L);
		i1.setName("BF-1");
		i1.setPrice(45.50);
		i1.setStatus(Status.PLACED);
		Set<String> tags = new HashSet<>();
		tags.add("Hot deal");
		tags.add("Fast selling");
		tags.add("Breakfast");
		i1.setTags(tags);
		i1.setMenu(m1);
		items.add(i1);
		m1.setItems(items);
		menu.add(m1);
		r.setMenu(menu);
		List<RestaurantAddress> branches = new ArrayList<>();
		RestaurantAddress ra1 = new RestaurantAddress();
		ra1.setRestaurantAddressId(1L);
		ra1.setRestaurant(r);
		Address a1 = new Address();
		a1.setAddressName("Address 1");
		a1.setCity("Chennai");
		a1.setCountry("India");
		a1.setDoorNo("100");
		a1.setState("Tamilnadu");
		a1.setSteet("test");
		a1.setZipCode(600002);
		ra1.setAddress(a1);
		branches.add(ra1);
		r.setBranches(branches);
		return r;
	}

	public static User testUser() {
		User user = new User();
		user.setAddedOn(LocalDateTime.now());
		user.setCreatedBy("testUser1");
		user.setEmailId("tester@domain.com");
		user.setMobileNo(9999999999L);
		user.setUpdatedBy("testUser2");
		user.setUserId(1L);
		user.setUserName("tester");
		user.setUserSince(LocalDateTime.of(2017, 4, 1, 0, 0));
		List<UserAddress> addresses = new ArrayList<UserAddress>();
		UserAddress ua1 = new UserAddress();
		ua1.setUserAddressId(1L);
		ua1.setUser(user);
		ua1.setDefault(false);
		Address a1 = new Address();
		a1.setAddressName("Home-1");
		a1.setCity("Chennai");
		a1.setCountry("India");
		a1.setDoorNo("1000");
		a1.setState("TN");
		a1.setSteet("Test Street");
		a1.setZipCode(600001);
		ua1.setAddress(a1);
		addresses.add(ua1);
		UserAddress ua2 = new UserAddress();
		ua2.setUserAddressId(2L);
		ua2.setUser(user);
		ua2.setDefault(true);
		Address a2 = new Address();
		a2.setAddressName("Home-2");
		a2.setCity("Chennai");
		a2.setCountry("India");
		a2.setDoorNo("2000");
		a2.setState("Tamilnadu");
		a2.setSteet("Test Street");
		a2.setZipCode(600002);
		ua2.setAddress(a2);
		addresses.add(ua2);
		user.setUserAddress(addresses);
		return user;
	}

	public static Order testOrder() {
		Order order = new Order();
		order.setAddedOn(LocalDateTime.now());
		order.setCreatedBy("tester");
		order.setDeliveryTime(LocalDateTime.now());
		order.setOrderedOn(LocalDateTime.now());
		order.setOrderId(10L);
		order.setStatus(Status.PROCESSING);
		order.setUpdatedOn(LocalDateTime.now());
		order.setUser(testUser());
		Delivery delivery = new Delivery();
		delivery.setDeliveryId(10L);
		delivery.setAddress(testUser().getUserAddress().get(0));
		delivery.setBikeNo("TN14 X1234");
		delivery.setBoxId("123");
		delivery.setContactNo(9513572580L);
		delivery.setDeliveryName("Delivery name");
		delivery.setOrder(order);
		delivery.setRegistrationDate(LocalDate.now());
		Track track = new Track();
		track.setTrackId(12L);
		List<TimeCoorinate> coorinates = new ArrayList<>();
		TimeCoorinate tc1 = new TimeCoorinate();
		tc1.setId(12L);
		tc1.setTime(LocalDateTime.now());
		tc1.setTrack(track);
		Coordinate co = new Coordinate();
		co.setLatitude(12.345);
		co.setLongitude(23.564);
		tc1.setCoordinate(co);
		coorinates.add(tc1);
		coorinates.add(tc1);
		track.setTimeCoorinates(coorinates);
		delivery.setTrack(track);
		order.setDelivery(delivery);
		OrderPrice price = new OrderPrice();
		price.setAmountPaid(120.50);
		price.setModeOfPay(ModeOfPay.COD);
		price.setTotalAmount(245.50);
		order.setOrderPrice(price);
		List<OrderItem> items = new ArrayList<>();
		OrderItem oi1 = new OrderItem();
		oi1.setId(12L);
		oi1.setOrder(order);
		oi1.setItem(testRestaurant().getMenu().get(0).getItems().get(0));
		oi1.setPrice(130.54);
		oi1.setQuantity(4);
		items.add(oi1);
		items.add(oi1);
		order.setOrderItems(items);
		return order;
	}

}
