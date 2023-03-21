package com.architect.springboot.parameters;

import org.springframework.util.Assert;

public class MovieRatingCreationParameters {
  private final String title;
  private final Integer rating;

  public MovieRatingCreationParameters(String title, Integer rating) {
    Assert.notNull(title, "title should not be null");
    Assert.notNull(rating, "rating should not be null");
    this.title = title;
    this.rating = rating;
  }

  public String getTitle() {
    return title;
  }

  public Integer getRating() {
    return rating;
  }
}
