package br.com.elisvieira.diecast.model;

import java.util.Objects;

public class Driver {
    private final Integer id;
    private final String name;
    private final String country;

    public Driver(Integer id, String name, String country) {
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
        Driver driver = (Driver) o;
        return id.equals(driver.id) &&
                name.equals(driver.name) &&
                country.equals(driver.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, country);
    }
}
