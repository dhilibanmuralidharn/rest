/*
 *
 * You can use the following import statements
 * 
 * import javax.persistence.*;
 * 
 */

package com.example.dinemaster.model;

import javax.persistence.*;
import com.example.dinemaster.model.Restaurant;

@Entity
@Table(name = "chef")
public class Chef {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "firstname")
    private String firstName;

    @Column(name = "lastname")
    private String lastName;

    @Column(name = "expertise")
    private String expertise;

    @Column(name = "experienceyears")
    private int experienceYears;

    @ManyToOne
    @JoinColumn(name = "restaurantId")
    private Restaurant restaurant;

    public Chef() {
    }

    public Chef(int id, String firstName, String lastName, String expertise, int experienceYears,
            Restaurant restaurant) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.expertise = expertise;
        this.experienceYears = experienceYears;
        this.restaurant = restaurant;
    }

    public int getId() {
        return id;
    }

    public void setId(int chefId) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastname() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getExpertise() {
        return expertise;
    }

    public void setExpertise(String expertise) {
        this.expertise = expertise;
    }

    public int getExperienceYears() {
        return experienceYears;
    }

    public void setExperienceYears(int experienceYears) {
        this.experienceYears = experienceYears;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }
}
