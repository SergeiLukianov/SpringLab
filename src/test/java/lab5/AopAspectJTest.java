package lab5;

import model.lab5.aop.AopLog;
import model.lab5.model.ApuBar;
import model.lab5.model.Bar;
import model.lab5.model.Customer;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:context.xml")
public class AopAspectJTest {

    @Autowired
    private Bar bar;

    @Autowired
    private Customer customer;

    @Before
    public void setUp() throws Exception {
        bar.sellSquishee(customer);
    }

    @Test
    public void testBeforeAdvice() {
        assertTrue("Before advice is not good enough...", AopLog.getStringValue().contains("Hello"));
        assertTrue("Before advice is not good enough...", AopLog.getStringValue().contains("How are you doing?"));
        System.out.println(AopLog.getStringValue());
    }

    @Test
    public void testAfterAdvice() {
        System.out.println(AopLog.getStringValue());
        assertTrue("After advice is not good enough...", AopLog.getStringValue().contains("Good Bye!"));
    }

    @Test
    public void testAfterReturningAdvice() {
        assertTrue("Customer is broken", AopLog.getStringValue().contains("Good Enough?"));
    }

    @Test
    public void testAroundAdvice() {
        assertTrue("Around advice is not good enough...", AopLog.getStringValue().contains("Hi!"));
        assertTrue("Around advice is not good enough...", AopLog.getStringValue().contains("See you!"));
        System.out.println(AopLog.getStringValue());
    }

    @Test
    public void testAllAdvices() {
        assertFalse("barObject instanceof ApuBar", bar instanceof ApuBar);
    }
}