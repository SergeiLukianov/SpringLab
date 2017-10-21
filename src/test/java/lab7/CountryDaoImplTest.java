package lab7;

import labs.lab7.dao.CountryDao;
import labs.lab7.model.Country;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

//import org.apache.commons.logging.Log;
//import org.apache.commons.logging.LogFactory;

import java.util.List;

import static org.junit.Assert.assertEquals;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:orm-context")
public class CountryDaoImplTest {

//	private static Log log = LogFactory.getLog(CountryDaoImplTest.class);

    private Country exampleCountry = new Country("Australia", "AU");

    @Autowired
    private CountryDao countryDao;

    @Test
    public void testSaveCountry() {
        countryDao.save(exampleCountry);

        List<Country> countryList = countryDao.getAllCountries();
        assertEquals(3, countryList.size());
        assertEquals(exampleCountry, countryList.get(2));
    }

    @Test
    public void testGetAllCountries() {

        countryDao.save(new Country("Canada", "CA"));

        List<Country> countryList = countryDao.getAllCountries();
        assertEquals(1, countryList.size());
    }

    @Test
    public void testGetCountryByName() {
        countryDao.save(new Country("Australia", "AU"));

        Country country = countryDao.getCountryByName("Australia");
        assertEquals(exampleCountry, country);
    }
}
