package labs.lab7.dao.jpa;

import labs.lab7.dao.CountryDao;
import labs.lab7.model.Country;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class CountryJpaDaoImpl extends AbstractJpaDao implements CountryDao {

    public void save(Country country) {
        EntityManager em = emf.createEntityManager();
        if (em != null) {
            em.getTransaction().begin();
            em.persist(country);
            em.getTransaction().commit();

            em.close();
        }
    }

    public List<Country> getAllCountries() {
        EntityManager em = emf.createEntityManager();
        List<Country> result = null;
        if (em != null) {
            result = em.createQuery("from Country").getResultList();
            em.close();
        }

        return result;
    }

    public Country getCountryByName(String name) {
        Country country = null;
        EntityManager em = emf.createEntityManager();

        country = em.createQuery("select c from Country c where c.name like :name", Country.class)
                .setParameter("name", name).getSingleResult();
        em.close();

        return country;
    }
}
