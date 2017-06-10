package com.hoteats.commons;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

import com.hoteats.common.review.AppFeedback;
import com.hoteats.common.review.Feedback;
import com.hoteats.common.review.ItemFeedback;
import com.hoteats.common.review.OrdersFeedback;
import com.hoteats.common.review.RestaurantFeedback;
import com.hoteats.models.Coordinate;
import com.hoteats.models.Delivery;
import com.hoteats.models.EatItem;
import com.hoteats.models.Item;
import com.hoteats.models.ItemOffer;
import com.hoteats.models.Location;
import com.hoteats.models.Menu;
import com.hoteats.models.OrderItem;
import com.hoteats.models.OrderPrice;
import com.hoteats.models.Orders;
import com.hoteats.models.Restaurant;
import com.hoteats.models.RestaurantAddress;
import com.hoteats.models.TimeCoorinate;
import com.hoteats.models.Track;
import com.hoteats.models.User;
import com.hoteats.models.UserAddress;
import com.hoteats.models.UserInfo;
import com.hoteats.models.enums.ItemType;
import com.hoteats.models.enums.ModeOfPay;
import com.hoteats.models.enums.OfferType;
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
		m1.setMenuId(1L);
		m1.setRestaurant(r);
		List<Item> items = new ArrayList<>();
		Item i1 = new Item();
		i1.setItemId(100L);
		i1.setName("BF-1");
		i1.setPrice(new BigDecimal("45.50"));
		i1.setStatus(Status.PLACED);
		ItemOffer of1 = new ItemOffer();
		// of1.setItemOfferId(100L);
		of1.setFlatDiscount(new BigDecimal(200.0));
		of1.setOfferPercentage(new BigDecimal(10.0));
		of1.setOfferFrom(LocalDateTime.of(2017, 01, 01, 00, 00, 00));
		of1.setOfferTill(LocalDateTime.of(2017, 12, 31, 00, 00, 00));
		of1.setOfferType(OfferType.PERCENTAGE);
		i1.setOffer(of1);
		Set<String> tags = new HashSet<>();
		tags.add("Hot deal");
		tags.add("Fast selling");
		tags.add("Breakfast");
		// i1.setTags(tags);
		i1.setMenu(m1);
		items.add(i1);
		m1.setItems(items);
		List<RestaurantAddress> branches = new ArrayList<>();
		RestaurantAddress ra1 = new RestaurantAddress();
		ra1.setAddressId(0L);
		ra1.setRestaurant(r);
		ra1.setAddressName("Address 1");
		ra1.setCity("Chennai");
		ra1.setCountry("India");
		ra1.setDoorNo("100");
		ra1.setState("Tamilnadu");
		ra1.setSteet("test");
		ra1.setZipCode(600002);
		Location l1 = new Location();
		l1.setDescription("RR Briyani medavakkam");
		l1.setLandmark("near medavakkam arch");
		l1.setLocationId(1l);
		l1.setTitle("RR Location");
		Coordinate co = new Coordinate();
		co.setLatitude(1.123);
		co.setLongitude(2.234);
		l1.setCoordinate(co);
		// ra1.setLocation(l1);
		branches.add(ra1);
		r.setBranches(branches);
		Menu m2 = new Menu();
		m2.setMenuId(2L);
		m2.setRestaurant(r);
		List<Item> it = items();
		it.stream().forEach(i -> i.setMenu(m2));
		m2.setItems(it);
		m2.setRestaurant(r);
		Menu m3 = new Menu();
		m3.setRestaurant(r);
		m3.setMenuId(3L);
		m3.setName("Eat Now");
		List<Item> ite = items().stream().peek(i -> i.setItemId(i.getItemId() + 150)).peek(i -> i.setMenu(m3))
				/*
				 * .peek(i -> i.getOffer().setItemOfferId(i.getItemId() + 150))
				 */.collect(Collectors.toList());
		m3.setItems(ite);
		menu.add(m1);
		menu.add(m2);
		menu.add(m3);
		r.setMenu(menu);
		return r;
	}

	public static List<EatItem> eatItems(ItemType itemType) {
		return items().stream().map(i -> itemToEatItem(i, itemType)).collect(Collectors.toList());
	}

	private static EatItem itemToEatItem(Item item, ItemType itemType) {
		EatItem eatItem = new EatItem();
		eatItem.setDescription(item.getDescription());
		// eatItem.setEatItemId(item.getItemId());
		eatItem.setName(item.getName());
		eatItem.setOffer(item.getOffer());
		eatItem.setPrice(item.getPrice());
		eatItem.setStatus(item.getStatus());
		eatItem.setType(itemType);
		return eatItem;
	}

	public static List<Item> items() {

		String itemsStr = "Idly 4::30 \n" + "Dosa 3::36 \n" + "Chappathi 3::36 \n" + "Puttu 3::36 \n"
				+ "Idiyappam 5::30 \n" + "Pongal 1::36 \n" + "Vada 1::9 \n" + "Boiled Egg 1::10 \n" + "Omlet 1::12 \n"
				+ "Panniyaram 10::36 \n" + "Spcl Dosa 1::19 \n" + "Dosa Combo (1 Spcl + Normal) 3::44 \n"
				+ "Dosa Vaada Combo(3 Dosa + 1 Vada) 3+1::44 \n" + "Dosa Omlet Combo(3 +1) 3+1::46 \n"
				+ "Dosa Egg Combo 3+1::45 \n" + "Idly + Vada Combo (4 Idly +1 Vada ) 4+1::36 \n"
				+ "Idly + Egg Combo (4 Idly +1 Vada ) 4+1::40 \n" + "Idly+ Omlet Combo (4 idly +1 Omlet) 4+1::42 \n"
				+ "Pongal + Vada Combo(1+1) 1+1::44 \n" + "Chappathi + Egg(3+1) 3+1::45 \n"
				+ "Chappathi+Omlet(3+1) 3+1::46 \n";
		String[] lines = itemsStr.split("\n");
		List<Item> items = new ArrayList<>();
		for (int i = 0; i < lines.length; i++) {
			String[] arr = lines[i].split("::");
			items.add(item(i, arr[0].trim(), arr[1].trim()));
		}
		return items;
	}

	public static Item item(int id, String name, String price) {
		// List<String> tags = new ArrayList<>(Arrays.asList("hot", "best",
		// "fast", "breakfast", "combo", "lunch", "dinner"));
		Item i1 = new Item();
		i1.setItemId((long) id);
		i1.setName(name);
		// i1.setTags(randomTags(tags));
		i1.setDescription(i1.getName());
		i1.setType(name.contains("+") ? ItemType.COMBO : ItemType.NORMAL);
		i1.setPrice(new BigDecimal(Double.parseDouble(price)));
		i1.setStatus(Status.AVAILABLE);
		i1.setOffer(randomOffers(id, Double.parseDouble(price)));
		// i1.getOffer().setItem(i1);
		return i1;
	}

	// private static Set<String> randomTags(List<String> tags) {
	// Collections.shuffle(tags);
	// return new HashSet<>(tags.subList(0,
	// ThreadLocalRandom.current().nextInt(tags.size() / 2, tags.size())));
	// }

	private static ItemOffer randomOffers(int id, double price) {
		LocalDateTime start = LocalDateTime.of(2017, 1, 1, 0, 0);
		LocalDateTime end = LocalDateTime.of(2017, 12, 31, 0, 0);
		ItemOffer o = new ItemOffer();
		o.setFlatDiscount(new BigDecimal(ThreadLocalRandom.current().nextInt(0, (int) price)));
		// o.setItemOfferId((long) id);
		o.setOfferFrom(start.plusDays(ThreadLocalRandom.current().nextLong(0, 30)));
		o.setOfferTill(end.minusDays(ThreadLocalRandom.current().nextLong(0, 30)));
		o.setOfferPercentage(new BigDecimal(ThreadLocalRandom.current().nextInt(0, 50)));
		o.setOfferType(ThreadLocalRandom.current().nextBoolean() ? OfferType.FLAT_DISCOUNT : OfferType.PERCENTAGE);
		return o;
	}

	public static User testUser() {
		User user = new User();
		UserInfo userInfo = new UserInfo();
		userInfo.setUserInfoId(1L);
		userInfo.setEmailId("tester@domain.com");
		userInfo.setMobileNo("9999999999");
		user.setUserId(1L);
		user.setUsername("tester");
		userInfo.setUserSince(LocalDateTime.of(2017, 4, 1, 0, 0));
		List<UserAddress> addresses = new ArrayList<UserAddress>();
		UserAddress ua1 = new UserAddress();
		ua1.setAddressId(1L);
		ua1.setUserInfo(userInfo);
		ua1.setDefault(false);
		ua1.setAddressName("Home-1");
		ua1.setCity("Chennai");
		ua1.setCountry("India");
		ua1.setDoorNo("1000");
		ua1.setState("TN");
		ua1.setSteet("Test Street");
		ua1.setZipCode(600001);
		UserAddress ua2 = new UserAddress();
		ua2.setAddressId(2L);
		ua2.setUserInfo(userInfo);
		ua2.setDefault(true);
		ua2.setAddressName("Home-2");
		ua2.setCity("Chennai");
		ua2.setCountry("India");
		ua2.setDoorNo("2000");
		ua2.setState("Tamilnadu");
		ua2.setSteet("Test Street");
		ua2.setZipCode(600002);
		Location l1 = new Location();
		l1.setDescription("RR Briyani medavakkam");
		l1.setLandmark("near medavakkam arch");
		l1.setLocationId(2l);
		l1.setTitle("RR Location");
		Coordinate co = new Coordinate();
		co.setLatitude(1.123);
		co.setLongitude(2.234);
		l1.setCoordinate(co);
		// ua2.setLocation(l1);
		addresses.add(ua1);
		addresses.add(ua2);
		userInfo.setUserAddress(addresses);
		userInfo.setUser(user);
		user.setUserInfo(userInfo);
		return user;
	}

	public static Orders testOrder() {
		Orders order = new Orders();
		order.setOrderedOn(LocalDateTime.now());
		order.setOrderId(10L);
		order.setStatus(Status.PROCESSING);
		order.setUpdatedOn(LocalDateTime.now());
		order.setUser(testUser());
		Delivery delivery = new Delivery();
		delivery.setDeliveryId(10L);
		delivery.setAddress(testUser().getUserInfo().getUserAddress().get(0));
		Track track = new Track();
		track.setBikeNo("TN14 X1234");
		track.setBoxId("123");
		delivery.setMobile(9513572580L);
		delivery.setOrders(order);
		track.setRegistrationDate(LocalDate.now());
		track.setTrackId(1l);
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
		track.setTimeCoorinates(coorinates);
		order.setDelivery(delivery);
		OrderPrice price = new OrderPrice();
		price.setAmountPaid(120.50);
		price.setModeOfPay(ModeOfPay.COD);
		price.setTotalAmount(245.50);
		order.setOrderPrice(price);
		List<OrderItem> items = new ArrayList<>();
		OrderItem oi1 = new OrderItem();
		oi1.setOrderItemId(12L);
		oi1.setOrders(order);
		oi1.setItem(testRestaurant().getMenu().get(0).getItems().get(0));
		oi1.setPrice(BigDecimal.TEN);
		oi1.setQuantity(4);
		items.add(oi1);
		order.setOrderItems(items);
		return order;
	}

	public static List<Feedback> sampleFeedbacks() {
		ItemFeedback it = new ItemFeedback();
		Item i = new Item();
		i.setItemId(100L);
		it.setItem(i);
		OrdersFeedback or = new OrdersFeedback();
		Orders o = new Orders();
		o.setOrderId(10L);
		or.setOrders(o);
		AppFeedback ap = new AppFeedback();
		ap.setFeature("UI");
		ap.setFeedbacks("Looks Good");
		RestaurantFeedback re = new RestaurantFeedback();
		Restaurant r = new Restaurant();
		r.setRestaurantId(100L);
		re.setRestaurant(r);
		List<Feedback> feedbacks = Arrays.asList(it, or, ap, re);
		User u = new User();
		u.setUserId(1L);
		for (Feedback feedback : feedbacks) {
			feedback.setAddedOn(LocalDateTime.now().minusDays(1));
			feedback.setRating(4);
			feedback.setReview("Good");
			feedback.setUpdatedOn(LocalDateTime.now());
			feedback.setUser(u);
		}
		return feedbacks;
	}

}
