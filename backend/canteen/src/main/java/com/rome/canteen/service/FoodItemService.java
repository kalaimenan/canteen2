package com.rome.canteen.service;

import com.rome.canteen.model.FoodItem;
import com.rome.canteen.repository.FoodItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FoodItemService {

    @Autowired
    private FoodItemRepository foodItemRepository;

    public List<FoodItem> getAllFoodItems() {
        return foodItemRepository.findAll();
    }

    public Optional<FoodItem> getFoodItemById(String id) {
        return foodItemRepository.findById(id);
    }

    public void save(FoodItem foodItem) {
        // Save the food item to MongoDB
        foodItemRepository.save(foodItem);
    }

    public FoodItem updateFoodItem(String id, FoodItem foodItemDetails) {
        Optional<FoodItem> optionalFoodItem = foodItemRepository.findById(id);
        if (optionalFoodItem.isPresent()) {
            FoodItem foodItem = optionalFoodItem.get();
            foodItem.setName(foodItemDetails.getName());
            foodItem.setDescription(foodItemDetails.getDescription());
            foodItem.setPrice(foodItemDetails.getPrice());
            foodItem.setAvailability(foodItemDetails.getAvailability());
            foodItem.setMealType(foodItemDetails.getMealType());
            return foodItemRepository.save(foodItem);
        } else {
            return null; // Handle appropriately in the controller
        }
    }

    public void deleteFoodItem(String id) {
        foodItemRepository.deleteById(id);
    }
}
