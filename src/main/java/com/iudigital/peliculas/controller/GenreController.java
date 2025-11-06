package com.iudigital.peliculas.controller;

import com.iudigital.peliculas.dao.GenreDao;
import com.iudigital.peliculas.domain.Genre;
import java.sql.SQLException;
import java.util.List;

public class GenreController {
    
    private GenreDao genreDao;

    public GenreController() {
        genreDao = new GenreDao();
    }
    
    public List<Genre> getGenres() throws SQLException {
        return genreDao.getGenres();
    }
}
