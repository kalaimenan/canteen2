package com.rome.canteen.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "ratings")
public class Rating {

    @Id
    private String id;
    private String foodItemId;
    private double rating;  // Rating value, e.g., 4.5

    // Constructors, getters, and setters

    public Rating() {}

    public Rating(String foodItemId, double rating) {
        this.foodItemId = foodItemId;
        this.rating = rating;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFoodItemId() {
        return foodItemId;
    }

    public void setFoodItemId(String foodItemId) {
        this.foodItemId = foodItemId;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }
}
