package com.rome.canteen.controller;

import com.rome.canteen.model.Rating;
import com.rome.canteen.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ratings")
public class RatingController {

    @Autowired
    private RatingService ratingService;

    @PostMapping
    public Rating addRating(@RequestBody Rating rating) {
        return ratingService.addRating(rating);
    }

    @GetMapping("/foodItem/{foodItemId}")
    public List<Rating> getRatingsByFoodItemId(@PathVariable String foodItemId) {
        return ratingService.getRatingsByFoodItemId(foodItemId);
    }
}
