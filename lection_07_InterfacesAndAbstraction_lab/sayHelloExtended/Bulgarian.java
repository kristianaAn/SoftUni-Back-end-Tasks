package lection_07_InterfacesAndAbstraction_lab.sayHelloExtended;

public class Bulgarian extends BasePerson{

    public Bulgarian(String name) {
        super(name);
    }

    @Override
    public String sayHello() {
        return "Здравей";
    }
}