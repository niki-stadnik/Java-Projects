package SpisakAvtomobili;

import java.util.Objects;

public class Person {
    private String name;
    private double funds;

    public Person(String name, double funds) {
        this.name = name;
        this.funds = funds;
    }

    public String getName() {
        return name;
    }

    public double getFunds() {
        return funds;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Double.compare(person.funds, funds) == 0 &&
                Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, funds);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", funds=" + funds +
                '}';
    }
}
