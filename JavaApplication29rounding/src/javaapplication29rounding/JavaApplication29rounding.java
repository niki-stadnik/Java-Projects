package javaapplication29rounding;

import java.math.BigDecimal;

public class JavaApplication29rounding {

    public static void main(String[] args) {
        System.out.println(1.03-0.42);
        
        BigDecimal x1 = new BigDecimal("1.03");
        BigDecimal x2 = new BigDecimal("0.42");
        System.out.println(x1.subtract(x2));
        
        String s1 = "hello";
        String s2 = "hell";
        s2 += "o";
        System.out.println(s1.equals(s2));
        System.out.println(s2.equals(s1));
        
        
        Person p1 = new Person("Joe", 25, 35);
        Person p2 = new Person("Jake", 45, 15);
        p1.show();
        p2.show();
        
        p1.giveMoneyTo(p2, 3);
        
        p1.show();
        p2.show();
        
        MyEvilPerson p3 = new MyEvilPerson("Eve", 24, 0);
        
        p3.inventMoney();
        p3.show();
    }
}

class MyEvilPerson extends Person {
    public MyEvilPerson(String name, int age, int moneyOwned) {
        super(name,age,moneyOwned);
    }
    public void inventMoney() {
        this.moneyOwned+=100000;
    }
}

class Person {
    protected String name;
    protected int age;
    protected int moneyOwned;
    public Person(String name, int age, int moneyOwned) {
        this.name = name;
        this.age = age;
        this.moneyOwned = moneyOwned;
    }
    public void show() {
        System.out.println(name + " " + age+ " " + moneyOwned);
    }
    
    public void giveMoneyTo(Person person, int amount) {
        this.moneyOwned -= amount;
        person.moneyOwned += amount;
    }
}
