package lab5;


import model.lab5.aop.AopLog;
import model.lab5.model.Bar;
import model.lab5.model.Customer;

import model.lab5.model.CustomerBrokenException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:context.xml")
public class AopAspectJExceptionTest {

    @Autowired
    private Bar bar;

    @Autowired
    private Customer customer;

    @Before
    public void setUp() throws Exception {
        customer.setBroke(true);
    }

    @Test(expected = CustomerBrokenException.class)
    public void testAfterThrowingAdvice() {
        bar.sellSquishee(customer);

        assertTrue("Customer is broken ", AopLog.getStringValue().contains("Hmmm..."));
        System.out.println(AopLog.getStringValue());
    }

}
