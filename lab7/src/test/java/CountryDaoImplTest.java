import dao.CountryDao;
import model.Country;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.List;

import static org.junit.Assert.assertEquals;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:orm-context")
public class CountryDaoImplTest {

	private static Log log = LogFactory.getLog(CountryDaoImplTest.class);

    private Country exampleCountry = new Country("Australia", "AU");

    @Autowired
    private CountryDao countryDao;

    @Before
    public void init() {
        countryDao.save(exampleCountry);
    }

    @Test
    @DirtiesContext
    public void testSaveCountry() {
        List<Country> countryList = countryDao.getAllCountries();
        assertEquals(1, countryList.size());
        assertEquals(exampleCountry, countryList.get(0));
    }

    @Test
    @DirtiesContext
    public void testGetAllCountries() {
        countryDao.save(new Country("Canada", "CA"));

        List<Country> countryList = countryDao.getAllCountries();
        assertEquals(2, countryList.size());
    }

    @Test
    @DirtiesContext
    public void testGetCountryByName() {
        Country country = countryDao.getCountryByName("Australia");
        assertEquals(exampleCountry, country);
    }
}
