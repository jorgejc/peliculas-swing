package com.iudigital.peliculas.dao;

import com.iudigital.peliculas.config.ConnectionConfig;
import com.iudigital.peliculas.domain.Genre;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GenreDao {
    
    private static final String GET_GENRES = "select * from genre";
    
    public List<Genre> getGenres() throws SQLException {
        
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Genre> genres = new ArrayList<>();
        
        try {
            
         connection = ConnectionConfig.getConnection();
         preparedStatement = connection.prepareStatement(GET_GENRES);
         resultSet = preparedStatement.executeQuery(); 
         
         while (resultSet.next()) {
             Genre genre = new Genre();
             genre.setId(resultSet.getInt("genre_id"));
             genre.setNombre(resultSet.getString("name"));
             genres.add(genre);
         }
         return genres;
         
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
