package br.com.elisvieira.diecast.model;

import java.util.Objects;

public class Team {

    private final Integer id;
    private final String name;
    private final String country;

    public Team(Integer id, String name, String country) {
        this.id = id;
        this.name = name;
        this.country = country;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Team team = (Team) o;
        return id.equals(team.id) &&
                name.equals(team.name) &&
                country.equals(team.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, country);
    }
}
