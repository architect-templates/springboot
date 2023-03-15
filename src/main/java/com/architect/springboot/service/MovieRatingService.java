package com.architect.springboot.service;

import java.util.List;
import java.util.ArrayList;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.architect.springboot.model.MovieRating;
import com.architect.springboot.repository.MovieRatingRepository;
import com.architect.springboot.parameters.MovieRatingCreationParameters;


@Service
public class MovieRatingService {

  @Autowired
  private MovieRatingRepository movieRatingRepository;

  public List<MovieRating> getAllMovieRatings() {
    List<MovieRating> movieRatings = new ArrayList<MovieRating>();
    movieRatingRepository.findAll().forEach(movieRatings::add);
    return movieRatings;
  }

  public MovieRating saveMovieRating(MovieRatingCreationParameters movieRatingCreationParameters) {
    MovieRating newMovieRating = new MovieRating();
    newMovieRating.setTitle(movieRatingCreationParameters.getTitle());
    newMovieRating.setRating(movieRatingCreationParameters.getRating());
    return movieRatingRepository.save(newMovieRating);
  }
}
