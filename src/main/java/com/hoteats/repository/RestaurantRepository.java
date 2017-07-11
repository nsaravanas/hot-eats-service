package com.hoteats.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hoteats.models.Coordinate;
import com.hoteats.models.Restaurant;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
	// @Query("from Restaurant r where r.branches.location.coordinate = ?1 ")
	@Query("from Restaurant r")
	List<Restaurant> restaurantsByGeo(Coordinate coordinate);

	// @Query("from Restaurant r where r.branches.location.landmark = ?1 ")
	@Query("from Restaurant r")
	List<Restaurant> restaurantsByLocation(String location);

}
