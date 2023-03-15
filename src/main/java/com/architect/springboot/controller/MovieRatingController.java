package com.architect.springboot.controller;

import java.util.List;
import java.util.ArrayList;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.validation.BindingResult;
import javax.validation.Valid;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMethod;
import com.architect.springboot.model.MovieRating;
import com.architect.springboot.repository.MovieRatingRepository;
import com.architect.springboot.service.MovieRatingService; // TODO: check that all imports are neccessary here and in other files
import com.architect.springboot.parameters.CreateMovieRatingFormData;


@Controller
public class MovieRatingController {

  @Autowired
  private MovieRatingService movieRatingService;

  @GetMapping("/")
  public String getIndex(Model model) {
    List<MovieRating> movieRatings = movieRatingService.getAllMovieRatings();
    model.addAttribute("movieRatings", movieRatings);
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
    List<MovieRating> movieRatings = movieRatingService.getAllMovieRatings();
    return ResponseEntity.ok(movieRatings);
  }

  @PostMapping("/movierating")
  public String createMovieRating(@Valid @ModelAttribute("formData") CreateMovieRatingFormData formData,
                               BindingResult bindingResult,
                               Model model) {
    if (bindingResult.hasErrors()) {
        return "/";
    }

    movieRatingService.saveMovieRating(formData.toParameters());
    return "redirect:/";
  }
}
