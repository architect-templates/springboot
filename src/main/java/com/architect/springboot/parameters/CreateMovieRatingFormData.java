package com.architect.springboot.parameters;

import com.architect.springboot.parameters.MovieRatingCreationParameters; // TODO: are these in the right places?

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class CreateMovieRatingFormData {
    @NotNull
    @Size(min = 1, max = 100)
    private String title;

    @NotNull
    @Size(min = 1, max = 1)
    private int rating;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title ;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public MovieRatingCreationParameters toParameters() {
        return new MovieRatingCreationParameters(title, rating);
    }
}
