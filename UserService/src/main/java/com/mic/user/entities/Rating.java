package com.mic.user.entities;

import jakarta.persistence.Transient;

public class Rating {
    private String ratingId;
    private String userId;
    private String hotelId;
    private int rating;
    private String feedback;

    @Transient
    private Hotel hotel; // Assuming you have a Hotel class for hotel details

    public Rating() {
    }

    public Rating(String ratingId, String userId, String hotelId, int rating, String feedback , Hotel hotel) {
        this.ratingId = ratingId;
        this.userId = userId;
        this.hotelId = hotelId;
        this.rating = rating;
        this.feedback = feedback;
        this.hotel = hotel;
    }

    public String getRatingId() {
        return ratingId;
    }
    public void setRatingId(String ratingId) {
        this.ratingId = ratingId;
    }
    public String getUserId() {
        return userId;
    }
    public void setUserId(String userId) {
        this.userId = userId;
    }
    public String getHotelId() {
        return hotelId;
    }
    public void setHotelId(String hotelId) {
        this.hotelId = hotelId;
    }
    public int getRating() {
        return rating;
    }
    public void setRating(int rating) {
        this.rating = rating;
    }
    public String getFeedback() {
        return feedback;
    }
    public void setFeedback(String feedback) {
        this.feedback = feedback;   
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }
}
