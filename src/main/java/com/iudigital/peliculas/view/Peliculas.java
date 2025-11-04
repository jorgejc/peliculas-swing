package com.iudigital.peliculas.view;

import com.iudigital.peliculas.controller.MovieController;
import com.iudigital.peliculas.domain.Movie;
import java.sql.SQLException;
import java.util.List;

public class Peliculas {

    public static void getMovies(MovieController movieController) {
        
        try {
            List<Movie> movies = movieController.getMovies();
            if (movies.isEmpty()) {
                System.out.println("No hay datos");
            } else {
                movies.forEach(movie -> {
                    System.out.println("id: " + movie.getId());
                    System.out.println("Titulo:" + movie.getTitulo());
                    System.out.println("Año:" + movie.getAnio());
                    System.out.println("Actor:" + movie.getActor());
                    System.out.println("Genero:" + movie.getGenero());
                    System.out.println("Nombre genero:" + movie.getNombreGenero());
                    System.out.println("Fecha creacion:" + movie.getFechaCreacion());
                    
                    System.out.println("===============================================");
                    System.out.println("===============================================");
                });
            }
        } catch (SQLException ex) {
           ex.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        
        MovieController movieController = new MovieController();
        getMovies(movieController);
    }
}
