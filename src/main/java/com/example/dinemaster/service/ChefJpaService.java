/*
 *
 * You can use the following import statements
 * 
 * import org.springframework.beans.factory.annotation.Autowired;
 * import org.springframework.http.HttpStatus;
 * import org.springframework.stereotype.Service;
 * import org.springframework.web.server.ResponseStatusException;
 * import java.util.ArrayList;
 * import java.util.List;
 * 
 */

package com.example.dinemaster.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;

import com.example.dinemaster.model.Chef;
import com.example.dinemaster.repository.ChefJpaRepository;
import com.example.dinemaster.repository.ChefRepository;
import com.example.dinemaster.model.Restaurant;
import com.example.dinemaster.repository.RestaurantJpaRepository;
import com.example.dinemaster.service.RestaurantJpaService;

@Service

public class ChefJpaService implements ChefRepository {

	@Autowired
	private ChefJpaRepository chefJpaRepository;

	@Autowired
	private RestaurantJpaRepository restaurantJpaRepository;

	@Override
	public ArrayList<Chef> getChefs() {
		List<Chef> chefList = chefJpaRepository.findAll();
		ArrayList<Chef> chefs = new ArrayList<>(chefList);
		return chefs;
	}

	@Override
	public Chef getChefById(int chefId) {
		try {
			Chef chef = chefJpaRepository.findById(chefId).get();
			return chef;
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}

	@Override
	public Chef addChef(Chef chef) {
		Restaurant restaurant = chef.getRestaurant();
		int restaurantId = restaurant.getId();
		try {
			Restaurant newRestaurant = restaurantJpaRepository.findById(restaurantId).get();
			chef.setRestaurant(newRestaurant);
			chefJpaRepository.save(chef);
			return chef;
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}

	@Override
	public Chef updateChef(int chefId, Chef chef) {
		try {
			Chef newChef = chefJpaRepository.findById(chefId).get();
			if (chef.getFirstName() != null) {
				newChef.setFirstName(chef.getFirstName());
			}
			if (chef.getLastname() != null) {
				newChef.setLastName(chef.getLastname());
			}
			if (chef.getExpertise() != null) {
				newChef.setExpertise(chef.getExpertise());
			}
			if (chef.getExperienceYears() != 0) {
				newChef.setExperienceYears(chef.getExperienceYears());
			}
			if (chef.getRestaurant() != null) {
				Restaurant restaurant = chef.getRestaurant();
				int restaurantid = restaurant.getId();
				Restaurant newRestaurant = restaurantJpaRepository.findById(restaurantid).get();
				newChef.setRestaurant(newRestaurant);
			}
			chefJpaRepository.save(newChef);
			return newChef;
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}

	@Override
	public void deleteChef(int id) {
		try {
			chefJpaRepository.deleteById(id);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		throw new ResponseStatusException(HttpStatus.NO_CONTENT);
	}

	@Override
	public Restaurant getRestaurantChef(int chefId) {
		try {
			Chef chef = chefJpaRepository.findById(chefId).get();
			return chef.getRestaurant();
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}

}