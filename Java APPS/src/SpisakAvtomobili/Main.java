package SpisakAvtomobili;

import java.util.*;

public class Main
{
    public static void main(String[] args) {
        Avtomobil car1=new Avtomobil(3000,"Opel",1999);
        Avtomobil car3=new Avtomobil(3000,"VW",1999);
        Avtomobil car2=new Avtomobil(2500,"VW",1998);
        Set<Avtomobil>cars=new TreeSet<>();
        cars.add(car1);
        cars.add(car2);
        cars.add(car3);
        System.out.println(cars);

        Person hora= new Person("Pesho",10000);
        Person hora1= new Person("ivan",20000);
        List<Person>people=new LinkedList<>();
        people.add(hora);
        people.add(hora1);
        Map<Person, List<Avtomobil>> own = new HashMap<>();
        System.out.println(sell(cars, people, own));
    }
    public static  Map<Person,List<Avtomobil>> sell (Set<Avtomobil>cars, List<Person>people, Map<Person,List<Avtomobil>>own){
        for (Iterator<Avtomobil> iterator = cars.iterator(); iterator.hasNext(); ) {
            Avtomobil car = iterator.next();

            for (Person person : people) {
                if (f(car, person)) {
                    addToMap(own, person, car);
                    cars.remove(car);
                    break;
                }
            }
        }

        return own;

    }

    private static void addToMap(Map<Person,List<Avtomobil>> map, Person person, Avtomobil avtomobil) {
         if (map.containsKey(person)) {
                List<Avtomobil> lsit = map.get(person);
                lsit.add(avtomobil);
    //            map.get(person).add(avtomobil);
        } else {
            List<Avtomobil> cars = new LinkedList<>();
            cars.add(avtomobil);
            map.put(person, cars);
        }
    }

    public static boolean f(Avtomobil avtomobil, Person person) {
        return new Random().nextBoolean();
    }
}
