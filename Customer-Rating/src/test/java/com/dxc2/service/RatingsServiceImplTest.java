package com.dxc2.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import com.dxc2.Repo.ReviewRepo;
import com.dxc2.model.Rating;

@SpringBootTest
public class RatingsServiceImplTest

{

    @Autowired
    private RatingsService service;
    @MockBean
    private ReviewRepo repository;

    @Test
    public void createComment() {

        Rating ratings = new Rating(1, 1, "Teja", 5, "good", "1/2/2023");
        when(repository.save(ratings)).thenReturn(ratings);
        assertEquals(ratings, service.addRating(ratings));
    }

    @Test
    public void getAllComments() {
    	
    	when(repository.findAll()).thenReturn((List<Rating>) Stream
    			.of(new Rating(1,1,"Teja", 5, "bad", "1/2/2023")).collect(Collectors.toList()));
    	assertEquals(1, service.AllRatings().size());
    }
    
    @Test
	public void updateRatingTest() {
		
		Rating rating = new Rating();
		rating.setComment("bad");
		rating.setRating(9);
		when(repository.save(any(Rating.class))).thenReturn(rating);
        Rating saverate = repository.save(rating);
        assertThat(saverate.getComment()).isNotNull();
        assertThat(saverate.getRating()).isNotNull();
    }
    
    @Test
	public void deleteproductbyIdTest() {
		
    	int id =1;
		service.deleteRating(id);
	    verify(repository,times(1)).deleteById(id);
		
	}
}
