package com.moviedatabase.dao;

import com.moviedatabase.entity.Movie;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MovieDAO {

    public List<Movie> movies;

    public MovieDAO() {
        this.movies = new ArrayList<>();
    }

    public Movie addMovie(Movie movie) {
        movies.add(movie);
        return movie;
    }

    public void setMarkMovie(String title, Movie movie) {
        String oldTitle = movie.getTitle();
        String newTitle = "WYPOŻYCZONY " + oldTitle;
        movie.setTitle(newTitle);
    }

    public void deleteMovie(String title, Movie movie) {
        String oldTitle = movie.getTitle();
        String newTitle = oldTitle.replaceAll("WYPOŻYCZONY ", "");
        movie.setTitle(newTitle);
    }

}