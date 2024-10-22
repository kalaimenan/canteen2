package com.rome.canteen.repository;

import com.rome.canteen.model.FoodItem;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FoodItemRepository extends MongoRepository<FoodItem, String> {
}
