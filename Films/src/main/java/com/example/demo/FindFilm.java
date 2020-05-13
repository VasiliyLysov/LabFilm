package com.example.demo;
import java.util.List;

    public interface FindFilm {

        List<Film> findAll();
        Film findById(Long id);
        void insertFilm(String name, String Producer);

        void deleteById(long parseLong);
    }

