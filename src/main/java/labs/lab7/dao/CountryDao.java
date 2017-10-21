package labs.lab7.dao;

import labs.lab7.model.Country;

import java.util.List;

public interface CountryDao {

    public abstract void save(Country country);

    public abstract List<Country> getAllCountries();

    public abstract Country getCountryByName(String name);
}
