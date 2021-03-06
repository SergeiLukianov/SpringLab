package dao;

import domain.Country;

import java.util.List;

public interface CountryDao {

    public void insert(Country user);

    public Country select(int id);

    public List<Country> selectAll();
}
