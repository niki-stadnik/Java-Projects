package Naslevqvane;

// Използва Person !!!!!

public class Nasledqvane {
    public static void main(String[] args) {
        Person pl = new Person("Joe",6);        // ako vyvedem otricatelna stoinost za godini hvyrlq gre6ka
        pl.show();
        pl.ageGroup();

        Employee emp = new Employee("Ivancho", 16, 500, 2); // ako zaplatata e pod 500 dava gre6ka
        emp.show();                                                                     // ako staja + 14 e pove4e ot vuzrastta dava gre6ka
        emp.ageGroup();
        System.out.println(emp.showSalaryBonus());

        Person emp2 = new Employee("Jake", 22, 1100, 5);
        emp2.show();
        emp2.ageGroup();
        System.out.println(((Employee) emp2).showSalaryBonus());
    }
}
