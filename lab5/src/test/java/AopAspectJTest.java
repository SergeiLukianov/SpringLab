import aop.AopLog;
import model.ApuBar;
import model.Bar;
import model.Customer;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:aop-context")
public class AopAspectJTest {

    @Autowired
    private Bar bar;

    @Autowired
    private Customer customer;

    @Before
    public void setUp() throws Exception {
        AopLog.clear();
        bar.sellSquishee(customer);
    }

    @Test
    public void testBeforeAdvice() {
        System.out.println("testBeforeAdvice():\n" + AopLog.getStringValue());
        assertTrue("Before advice is not good enough...", AopLog.getStringValue().contains("Hello"));
        assertTrue("Before advice is not good enough...", AopLog.getStringValue().contains("How are you doing?"));
    }

    @Test
    public void testAfterAdvice() {
        System.out.println("testAfterAdvice():\n" + AopLog.getStringValue());
        assertTrue("After advice is not good enough...", AopLog.getStringValue().contains("Good Bye!"));
    }

    @Test
    public void testAfterReturningAdvice() {
        System.out.println("testAfterReturningAdvice():\n" + AopLog.getStringValue());
        assertTrue("Customer is broken", AopLog.getStringValue().contains("Good Enough?"));
    }

    @Test
    public void testAroundAdvice() {
        System.out.println("testAroundAdvice():\n" + AopLog.getStringValue());
        assertTrue("Around advice is not good enough...", AopLog.getStringValue().contains("Hi!"));
        assertTrue("Around advice is not good enough...", AopLog.getStringValue().contains("See you!"));
    }

    @Test
    public void testAllAdvices() {
        assertFalse("barObject instanceof ApuBar", bar instanceof ApuBar);
    }
}
