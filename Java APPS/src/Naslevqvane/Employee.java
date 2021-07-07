package Naslevqvane;

// Използва и Nasledqvane и Person

public class Employee extends Person {

    private int salary;
    private int experience;

    public Employee(String name, int age, int salary, int experience) {
        super(name, age);        // Подава данните които сме подали към наследения клас в случая Person!!
        if (salary<500){
            throw new IllegalArgumentException();
        }
        this.salary = salary;
        if (experience<0 || experience+14>age){
            throw new IllegalArgumentException();
        }
        this.experience = experience;
    }

    public void show() {
        System.out.println(name + " " + age + " " + salary + " " + experience);
    }

    public int showSalaryBonus() {
        return (int)(salary*0.01);

    }
}
