package br.com.elisvieira.diecast.model;

import java.util.Objects;

public class DiecastModel {

    private final Integer id;
    private final Team team;
    private final Driver driver;
    private final Integer year;
    private final Double price;
    private final Boolean constructorChampion;
    private final Boolean driverChampion;

    public DiecastModel(Integer id, Team team, Driver driver, Integer year, Double price, Boolean constructorChampion, Boolean driverChampion) {
        this.id = id;
        this.team = team;
        this.driver = driver;
        this.year = year;
        this.price = price;
        this.constructorChampion = constructorChampion;
        this.driverChampion = driverChampion;
    }

    public Integer getId() {
        return id;
    }

    public Team getTeam() {
        return team;
    }

    public Driver getDriver() {
        return driver;
    }

    public Integer getYear() {
        return year;
    }

    public Double getPrice() {
        return price;
    }

    public Boolean getConstructorChampion() {
        return constructorChampion;
    }

    public Boolean getDriverChampion() {
        return driverChampion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DiecastModel that = (DiecastModel) o;
        return id.equals(that.id) &&
                team.equals(that.team) &&
                driver.equals(that.driver) &&
                year.equals(that.year) &&
                price.equals(that.price) &&
                constructorChampion.equals(that.constructorChampion) &&
                driverChampion.equals(that.driverChampion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, team, driver, year, price, constructorChampion, driverChampion);
    }
}
