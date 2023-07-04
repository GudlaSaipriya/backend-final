package com.dxc2.service;

import java.util.List;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dxc2.Repo.ReviewRepo;
import com.dxc2.model.Rating;

@Service
public class RatingsServiceImpl implements RatingsService {

	@Autowired
	private ReviewRepo repo;
	
	
	@Override
	public Rating addRating(Rating ratings) {
		// TODO Auto-generated method stub
		return repo.save(ratings);
	}

	@Override
	public Rating editRating(int reviewId, Rating ratings) {
		// TODO Auto-generated method stub
		Rating r = repo.findById(reviewId).get();
		
		if(ratings.getRating()!=0) {
			r.setRating(ratings.getRating());
		}
		if((ratings.getComment()!=null) && (!"".equalsIgnoreCase(ratings.getComment()))){
			r.setComment(ratings.getComment());
		}
		return repo.save(r);
	}
	
	@Override
	public List<Rating> AllRatings() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}
	
	@Override
	public void deleteRating(int reviewId)  {

    	repo.deleteById(reviewId);
    }


	
	
	
	
//	@Override
//	public void deleteRating(int reviewId) {
//		// TODO Auto-generated method stub
//		repo.delete(read(reviewId));
//	}
	
	


//	public Rating read(int reviewId) {
//		Rating result = null;
//		Optional<Rating> temp = repo.findById(reviewId);
//		if(temp.isPresent()) {
//			result = repo.findById(reviewId).get();
//		}
//		return result;
//	}

	

	//public List<Rating> getAllRatings() {
		// TODO Auto-generated method stub
		//return repo.findAll();
		
	//}
	

}

