package com.moviedatabase.dao;

import com.moviedatabase.entity.Movie;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MovieDAO {

    public List<Movie> movies;

    public MovieDAO() {
        this.movies = new ArrayList<Movie>();
    }

    public Movie addMovie(Movie movie){
        movies.add(movie);
        return movie;
    }

    public List<Movie> getMovies(){
        return movies;
    }

    public Movie getMovieById(Long id) {
        if(id<movies.size()){
            return movies.get(Math.toIntExact(id));
        }else{
            return null;
        }
    }

}