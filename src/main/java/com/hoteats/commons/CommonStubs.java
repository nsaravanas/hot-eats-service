package com.hoteats.commons;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

import com.hoteats.models.Address;
import com.hoteats.models.Delivery;
import com.hoteats.models.Item;
import com.hoteats.models.ItemOffer;
import com.hoteats.models.Menu;
import com.hoteats.models.Order;
import com.hoteats.models.OrderItem;
import com.hoteats.models.OrderPrice;
import com.hoteats.models.Restaurant;
import com.hoteats.models.RestaurantAddress;
import com.hoteats.models.Track;
import com.hoteats.models.User;
import com.hoteats.models.UserAddress;
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
		m1.setId(1L);
		m1.setRestaurant(r);
		List<Item> items = new ArrayList<>();
		Item i1 = new Item();
		i1.setItemId(100L);
		i1.setName("BF-1");
		i1.setPrice(new BigDecimal("45.50"));
		i1.setStatus(Status.PLACED);
		ItemOffer of1 = new ItemOffer();
		of1.setItemOfferId(100L);
		of1.setFlatDiscount(new BigDecimal(200.0));
		of1.setOfferPercentage(new BigDecimal(10.0));
		of1.setItem(i1);
		of1.setOfferFrom(LocalDateTime.of(2017, 01, 01, 00, 00, 00));
		of1.setOfferTill(LocalDateTime.of(2017, 12, 31, 00, 00, 00));
		of1.setOfferType(OfferType.PERCENTAGE);
		i1.setOffer(of1);
		Set<String> tags = new HashSet<>();
		tags.add("Hot deal");
		tags.add("Fast selling");
		tags.add("Breakfast");
		i1.setTags(tags);
		i1.setMenu(m1);
		items.add(i1);
		m1.setItems(items);
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
		Menu m2 = new Menu();
		m2.setId(2L);
		m2.setRestaurant(r);
		List<Item> it = items();
		it.stream().forEach(i -> i.setMenu(m2));
		m2.setItems(it);
		m2.setRestaurant(r);
		menu.add(m1);
		menu.add(m2);
		r.setMenu(menu);
		return r;
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
		List<String> tags = new ArrayList<>(
				Arrays.asList("hot", "best", "fast", "breakfast", "combo", "lunch", "dinner"));
		Item i1 = new Item();
		i1.setItemId((long) id);
		i1.setName(name);
		i1.setTags(randomTags(tags));
		i1.setDescription(i1.getName());
		i1.setType(name.contains("+") ? ItemType.COMBO : ItemType.NORMAL);
		i1.setPrice(new BigDecimal(Double.parseDouble(price)));
		i1.setStatus(Status.AVAILABLE);
		i1.setOffer(randomOffers(id, Double.parseDouble(price)));
		i1.getOffer().setItem(i1);
		return i1;
	}

	private static Set<String> randomTags(List<String> tags) {
		Collections.shuffle(tags);
		return new HashSet<>(tags.subList(0, ThreadLocalRandom.current().nextInt(tags.size() / 2, tags.size())));
	}

	private static ItemOffer randomOffers(int id, double price) {
		LocalDateTime start = LocalDateTime.of(2017, 1, 1, 0, 0);
		LocalDateTime end = LocalDateTime.of(2017, 12, 31, 0, 0);
		ItemOffer o = new ItemOffer();
		o.setFlatDiscount(new BigDecimal(ThreadLocalRandom.current().nextDouble(0, price)));
		o.setItemOfferId((long) id);
		o.setOfferFrom(start.plusDays(ThreadLocalRandom.current().nextLong(0, 30)));
		o.setOfferTill(end.minusDays(ThreadLocalRandom.current().nextLong(0, 30)));
		o.setOfferPercentage(new BigDecimal(ThreadLocalRandom.current().nextDouble(0, 50.0)));
		o.setOfferType(ThreadLocalRandom.current().nextBoolean() ? OfferType.FLAT_DISCOUNT : OfferType.PERCENTAGE);
		return o;
	}

	public static User testUser() {
		User user = new User();
		user.setEmailId("tester@domain.com");
		user.setMobileNo(9999999999L);
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
		// List<TimeCoorinate> coorinates = new ArrayList<>();
		// TimeCoorinate tc1 = new TimeCoorinate();
		// tc1.setId(12L);
		// tc1.setTime(LocalDateTime.now());
		// tc1.setTrack(track);
		// Coordinate co = new Coordinate();
		// co.setLatitude(12.345);
		// co.setLongitude(23.564);
		// tc1.setCoordinate(co);
		// coorinates.add(tc1);
		// coorinates.add(tc1);
		// track.setTimeCoorinates(coorinates);
		delivery.setTrack(track);
		track.setDelivery(delivery);
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
