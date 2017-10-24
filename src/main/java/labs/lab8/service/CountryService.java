package labs.lab8.service;

import java.util.List;
import labs.lab8.model.Country;
import org.springframework.transaction.annotation.Propagation;

public interface CountryService {

    public List<Country> getAllCountriesInsideTransaction(Propagation propagation);

    public List<Country> getAllCountriesRequired();

    public List<Country> getAllCountriesRequiresNew();

    public List<Country> getAllCountriesSupports();

    public List<Country> getAllCountriesNever();

    public List<Country> getAllCountriesMandatory();

    public List<Country> getAllCountriesNotSupported();

    public List<Country> getAllCountries();
}
