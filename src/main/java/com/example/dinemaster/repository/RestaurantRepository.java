/*
 *
 * You can use the following import statements
 * 
 * import java.util.ArrayList;
 * 
 */

package com.example.dinemaster.repository;

import java.util.*;
import com.example.dinemaster.model.Restaurant;

public interface RestaurantRepository {
    ArrayList<Restaurant> getRestaurants();

    Restaurant getRestaurantById(int id);

    Restaurant addRestaurant(Restaurant restaurant);

    Restaurant updateRestaurant(int id, Restaurant restaurant);

    void deleteRestaurant(int id);
}