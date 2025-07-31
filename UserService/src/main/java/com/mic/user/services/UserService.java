package com.mic.user.services;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.mic.user.entities.Hotel;
import com.mic.user.entities.Rating;
import com.mic.user.entities.User;
import com.mic.user.exceptions.ResourceNotFoundException;
import com.mic.user.repositories.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public User getUserById(String id) {
        User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException());

        Rating[] ratings = restTemplate.getForObject("http://RATING-SERVICE/api/ratings/users/" + user.getId() , Rating[].class);


        List<Rating> ratingsOfHotel = Arrays.stream(ratings).map(rating -> {
            ResponseEntity<Hotel> forEntity = restTemplate.getForEntity("http://HOTEL-SERVICE/api/hotels/" + rating.getHotelId()  , Hotel.class);
            Hotel hotel = forEntity.getBody();
            rating.setHotel(hotel);

            return rating;

        }).collect(Collectors.toList());

        user.setRatings(ratingsOfHotel);
        return user;
    }

    public List<User> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users;
    }
}
