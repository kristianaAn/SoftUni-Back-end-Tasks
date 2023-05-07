package lection_07_InterfacesAndAbstraction_lab.sayHello;

public class BasePerson implements Person{
    private String name;

    public BasePerson(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String sayHello() {
        return "Hello";
    }
}
