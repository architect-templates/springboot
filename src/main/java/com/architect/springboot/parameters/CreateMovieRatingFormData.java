package com.architect.springboot.parameters;

import com.architect.springboot.parameters.MovieRatingCreationParameters;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.validation.constraints.Min;
import javax.validation.constraints.Max;

public class CreateMovieRatingFormData {
  @NotNull
  @Size(min = 1, max = 100)
  private String title;

  @NotNull
  @Min(1)
  @Max(5)
  private Integer rating;

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title ;
  }

  public Integer getRating() {
    return rating;
  }

  public void setRating(Integer rating) {
    this.rating = rating;
  }

  public MovieRatingCreationParameters toParameters() {
    return new MovieRatingCreationParameters(title, rating);
  }
}
