package com.example.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/")
public class controller {
    @Value("${spring.application.name}")
    String appName;

    @Autowired
    private findFilms filmService;
    @RequestMapping("/films")
    public List<Film> findFilms() {
        String error = "Malformed JSON request";
        return filmService.findAll();
    }
    @RequestMapping(value="/films/getFilm", method = RequestMethod.GET)
    public Film findFilm(@RequestParam("filmId") String filmId) {
        return filmService.findById(Long.parseLong(filmId));
    }

    @RequestMapping(value="/films/deleteFilm", method = RequestMethod.GET)
    public void deleteFilm(@RequestParam("filmId") String filmId) { filmService.deleteById(Long.parseLong(filmId)); }


    @RequestMapping(value = "/films/addFilm", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity sendViaResponseEntity() {
        return new ResponseEntity(HttpStatus.NOT_IMPLEMENTED);
    }

    @PostMapping(path = "/members", consumes = "application/json", produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public void createProfile(@Valid @RequestBody Film film) {
        filmService.insertFilm(film.getName(), film.getProducer());
    }

}