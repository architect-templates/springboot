package com.architect.springboot.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.architect.springboot.model.MovieRating;


@Repository
public interface MovieRatingRepository extends JpaRepository<MovieRating, Long> {

}
