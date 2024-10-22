package com.rome.canteen.repository;

import com.rome.canteen.model.Rating;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface RatingRepository extends MongoRepository<Rating, String> {
    List<Rating> findByFoodItemId(String foodItemId);
}
