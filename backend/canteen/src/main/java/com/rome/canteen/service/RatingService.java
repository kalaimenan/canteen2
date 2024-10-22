package com.rome.canteen.service;

import com.rome.canteen.model.Rating;
import com.rome.canteen.repository.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingService {

    @Autowired
    private RatingRepository ratingRepository;

    public Rating addRating(Rating rating) {
        return ratingRepository.save(rating);
    }

    public List<Rating> getRatingsByFoodItemId(String foodItemId) {
        return ratingRepository.findByFoodItemId(foodItemId);
    }
}
