package model;

import aop.AopLog;

public class ApuBar implements Bar {

    public Squishee sellSquishee(Customer customer) {
        if (customer.isBroke()){
            throw new CustomerBrokenException();
        } else {
            AopLog.append("Here is your squishee\n");
            return new Squishee("regular squishee");
        }
    }
}
