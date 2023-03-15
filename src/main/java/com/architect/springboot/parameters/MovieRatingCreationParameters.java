package com.architect.springboot.parameters;

import org.springframework.util.Assert;

public class MovieRatingCreationParameters { // TODO: 2 spaces everywhere
    private final String title;
    private final int rating;

    public MovieRatingCreationParameters(String title, int rating) {
        Assert.notNull(title, "title should not be null");
        Assert.notNull(rating, "rating should not be null");
        this.title = title;
        this.rating = rating;
    }

    public String getTitle() {
        return title;
    }

    public int getRating() {
        return rating;
    }
}
