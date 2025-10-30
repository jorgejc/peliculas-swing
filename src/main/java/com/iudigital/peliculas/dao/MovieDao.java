package com.iudigital.peliculas.dao;

import com.iudigital.peliculas.config.ConnectionConfig;
import com.iudigital.peliculas.domain.Movie;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class MovieDao {
    
    private static final String GET_MOVIES = "select movies.*, genre.name "
            + "from movies "
            + "inner join genre on movies.genre_id = genre.genre_id";
    
    private static final String CREATE_MOVIE = "insert into movies (titulo, anio, actor, "
            + "genre_id, fecha_creacion) values (?, ?, ?, ?, ?)";
    
    private static final String GET_MOVIE_BY_ID = "select movies.*, genre.name "
            + "from movies "
            + "inner join genre on movies.genre_id = genre.genre_id "
            + "where movies.movie_id = ?";
    
    private static final String UPDATE_MOVIE = "update movies set titulo = ?, "
            + "anio = ?, actor = ?, genre_id = ?, fecha_creacion = ? where movie_id = ?";
    
    private static final String DELETE_MOVIE = "delete from movies where movie_id = ?";
    
    
    
    public List<Movie> getMovies() throws SQLException {
        
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Movie> movies = new ArrayList<>();
        
        try {
            
         connection = ConnectionConfig.getConnection();
         preparedStatement = connection.prepareStatement(GET_MOVIES);
         resultSet = preparedStatement.executeQuery(); 
         
         while (resultSet.next()) {
             Movie movie = new Movie();
             movie.setId(resultSet.getInt("movie_id"));
             movie.setTitulo(resultSet.getString("titulo"));
             movie.setAnio(resultSet.getString("anio"));
             movie.setActor(resultSet.getString("actor"));
             movie.setGenero(resultSet.getString("genre_id"));
             movie.setNombreGenero(resultSet.getString("genre.name"));
             movie.setFechaCreacion(resultSet.getObject("fecha_creacion", LocalDateTime.class));
             movies.add(movie);
         }
         return movies;
         
        } finally {
            
            if (connection != null) {
                connection.close();
            }
            
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            
            if (resultSet != null) {
                resultSet.close();
            }
        } 
    }
}
