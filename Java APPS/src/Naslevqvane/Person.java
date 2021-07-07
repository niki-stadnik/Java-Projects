package Naslevqvane;

//  Използва се от Nasledqvane !!!

public class Person {             // ако сложим final пред class ще забраним наследяването от други класове
                                //  abstract ни задължава да ползваме наследяване
    protected String name;              // Protected?????
    protected int age;

    public Person(String name, int age) {
        this.name = name;
        if (age<0 || age>120){
            throw new IllegalArgumentException();
        }
        this.age = age;
    }

    public void show() {
        System.out.println(name + " " + age);
    }
    public void ageGroup() {
        System.out.print(name + " is ");
        if (age<=14){
            System.out.println("child");
        }else if(age<=18){
            System.out.println("adolescent");
        }else System.out.println("adult");

    }
}


/*
ako napi6em konstruktor s 1 parametur vmesto 2 toi pak trqbva da e sys sy6toto ime,
                               a vika6tiq klas go razpoznava po broq na promenlivite

    public Person(String name) {
        this.name = name
    }

 */