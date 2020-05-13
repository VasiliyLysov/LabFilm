package com.example.demo;


import java.util.Objects;
import java.util.StringJoiner;

public class Film {

    private Long id;
    private String name;
    private String Producer;

    public Film() {
    }

    public Film(Long id, String name, String Producer) {
        this.id = id;
        this.name = name;
        this.Producer = Producer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProducer() {
        return Producer;
    }

    public void setProducer(String Producer) {
        this.Producer = Producer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Film film = (Film) o;
        return Producer == film.Producer &&
                Objects.equals(id, film.id) &&
                Objects.equals(name, film.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, Producer);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Film.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("name='" + name + "'")
                .add("Producer='" + Producer + "'")
                .toString();
    }
}