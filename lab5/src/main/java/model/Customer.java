package model;

public class Customer {
    private String name;
    private boolean broke;

    public Customer() {
    }

    public Customer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean isBroke() {
        return broke;
    }

    public void setBroke(boolean broke) {
        this.broke = broke;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void sayHello(Person person) {
        System.out.printf("Hi %s! My name is %s.%n", person.getName(), getName());
    }
}
