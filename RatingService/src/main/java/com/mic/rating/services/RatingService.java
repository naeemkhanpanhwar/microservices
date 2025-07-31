package com.mic.rating.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mic.rating.entities.Rating;
import com.mic.rating.repositories.RatingRepository;

@Service
public class RatingService {

    @Autowired
    private RatingRepository ratingRepository;
    
    public Rating createRating(Rating rating) {
        return ratingRepository.save(rating);
    }

    public Rating getRatingById(String ratingId) {
        return ratingRepository.findById(ratingId).orElse(null); // Placeholder return
    }

    public List<Rating> getAllRatings() {
        return ratingRepository.findAll(); // Placeholder return
    }

    public List<Rating> getRatingsByUserId(String userId) {
        return ratingRepository.findByUserId(userId); // Placeholder return
    }

    public List<Rating> getRatingsByHotelId(String hotelId) {
        return ratingRepository.findByHotelId(hotelId); // Placeholder return
    }
}
