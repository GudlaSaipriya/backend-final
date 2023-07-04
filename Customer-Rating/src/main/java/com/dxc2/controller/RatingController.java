package com.dxc2.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dxc2.model.Rating;
import com.dxc2.service.RatingsService;

@RestController
@RequestMapping("/custom")
public class RatingController {
	
	@Autowired
	RatingsService service;
	
	@GetMapping("allratings")
	public List<Rating> getAllRatings(){    

        List<Rating> rating = service.AllRatings();

        return rating;
	}
	
	@PostMapping("/customerreview/comment")
	public Rating addReview(@RequestBody Rating ratings) {
		return service.addRating(ratings);
	}
	
	@PutMapping("/customerreview/editRatings/{reviewId}")
	public Rating editReview(@PathVariable("reviewId") int reviewId, @RequestBody Rating ratings) {
		return service.editRating(reviewId, ratings);
		
	}
	
	@DeleteMapping("/customerreview/remove/{reviewId}")
	public void deleteReview(@PathVariable int reviewId) {
		service.deleteRating(reviewId);
	}
}