package com.dxc2.service;

import java.util.List;


import com.dxc2.model.Rating;

public interface RatingsService {
	
	public Rating addRating(Rating ratings);
	public Rating editRating(int reviewId, Rating ratings);
	public void deleteRating(int reviewId);
	public List<Rating> AllRatings();
	

}
