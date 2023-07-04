package com.dxc2.Repo;

import org.springframework.data.jpa.repository.JpaRepository;


import com.dxc2.model.Rating;



public interface ReviewRepo extends JpaRepository<Rating, Integer> {

}

