package com.rome.canteen.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "orders")
public class Order {
    @Id
    private String id;
    private String category;
    private String timeSlot;
    private String userId;
    private String foodItemId;

    // Constructors, Getters, Setters, and toString() methods
    public Order() {}

    public Order(String category, String timeSlot, String userId, String foodItemId) {
        this.category = category;
        this.timeSlot = timeSlot;
        this.userId = userId;
        this.foodItemId = foodItemId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getTimeSlot() {
        return timeSlot;
    }

    public void setTimeSlot(String timeSlot) {
        this.timeSlot = timeSlot;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getFoodItemId() {
        return foodItemId;
    }

    public void setFoodItemId(String foodItemId) {
        this.foodItemId = foodItemId;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id='" + id + '\'' +
                ", category='" + category + '\'' +
                ", timeSlot='" + timeSlot + '\'' +
                ", userId='" + userId + '\'' +
                ", foodItemId='" + foodItemId + '\'' +
                '}';
    }
}
