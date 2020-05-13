package com.example.demo;

import java.util.List;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.server.ResponseStatusException;

@Service
public class findFilms implements FindFilm {

    @Autowired
    private JdbcTemplate jtm;

    @Override
    public List<Film> findAll() {

        String sql = "SELECT * FROM films";

        return jtm.query(sql, new BeanPropertyRowMapper<>(Film.class));
    }

    @Override
    public Film findById(Long id) {
        String sql = "SELECT * FROM films WHERE id = ?";

        return jtm.queryForObject(sql, new Object[]{id},
                new BeanPropertyRowMapper<>(Film.class));
    }

    @Override
    public void deleteById(long id) {
        String sql = "DELETE FROM films WHERE id = ? ";
        int res = jtm.update(sql, id);
        if (res == 0)
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Film not found"
            );
    }

    @Override
    public void insertFilm(String name, String producer) {
        //MapSqlParameterSource params = new MapSqlParameterSource();
        String sql = "INSERT INTO films(name, producer) VALUES (?, ?)";
        Object[] params = new Object[] {name, producer};

        jtm.update(sql, params);
        //params.addValue("firstName", firstName);
        //params.addValue("lastName", lastName);
        //params.addValue("age", age);
        //jdbcTemplate.update(SQL_INSERT_PROFILE, params);
    }
}