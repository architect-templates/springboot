package com.architect.springboot.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.validation.BindingResult;
import javax.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.architect.springboot.model.MovieRating;
import com.architect.springboot.service.MovieRatingService;
import com.architect.springboot.parameters.CreateMovieRatingFormData;

@Controller
public class MovieRatingController {

  @Autowired
  private MovieRatingService movieRatingService;

  @GetMapping("/")
  public String getIndex(Model model) {
    model.addAttribute("movieRatings", movieRatingService.getAllMovieRatings());
    model.addAttribute("formData", new CreateMovieRatingFormData());
    return "index";
  }

  @GetMapping("/health")
  @ResponseBody
  public ResponseEntity<String> healthCheck() {
    return ResponseEntity.ok("UP");
  }

  @GetMapping("/movierating")
  @ResponseBody
  public ResponseEntity<List<MovieRating>> getAllMovieRatings() {
    return ResponseEntity.ok(movieRatingService.getAllMovieRatings());
  }

  @PostMapping("/movierating")
  public String createMovieRating(@Valid @ModelAttribute("formData") CreateMovieRatingFormData formData, BindingResult bindingResult, Model model) {
    if (bindingResult.hasErrors()) {
      model.addAttribute("movieRatings", movieRatingService.getAllMovieRatings());
      return "index";
    }

    movieRatingService.saveMovieRating(formData.toParameters());
    return String.format("redirect:%s/", System.getenv("APP_URL"));
  }
}
