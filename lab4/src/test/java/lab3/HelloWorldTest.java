package lab3;

import model.Country;
import model.UsualPerson;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;
import static org.junit.Assert.*;


public class HelloWorldTest {

    protected static final String APPLICATION_CONTEXT_XML_FILE_NAME = "helloworld-context";

    private UsualPerson expectedPerson;

    private AbstractApplicationContext context;

    @Before
    public void setUp() throws Exception{
        context = new ClassPathXmlApplicationContext(APPLICATION_CONTEXT_XML_FILE_NAME);
        expectedPerson = getExpectedPerson();
    }

    @Test
    public void testInitPerson(){
        UsualPerson usualPerson = (UsualPerson) context.getBean("person");
        assertEquals(usualPerson, expectedPerson);
    }


    private UsualPerson getExpectedPerson(){
        UsualPerson usualPerson = new UsualPerson();
        usualPerson.setAge(35);
        usualPerson.setHeight(1.78f);
        usualPerson.setIsProgrammer(true);
        usualPerson.setContacts(Arrays.asList("asd@asd.ru", "+7-234-456-67-89"));
        usualPerson.setName("John Smith");
        usualPerson.setCountry(new Country("Russia", "RU"));

        return usualPerson;
    }

    @After
    public void tearDown(){
        if (context != null){
            context.close();
        }
    }
}
