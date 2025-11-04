package com.iudigital.peliculas.controller;

import com.iudigital.peliculas.dao.MovieDao;
import com.iudigital.peliculas.domain.Movie;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;

public class MovieController {
    
    private MovieDao movieDao;
    
    public MovieController() {
        movieDao = new MovieDao();
    }
    
    public List<Movie> getMovies() throws SQLException {
        return movieDao.getMovies();
    }
    
    public void create(Movie movie) throws SQLException {
        movie.setFechaCreacion(LocalDateTime.now());
        movieDao.create(movie);
    }
}
