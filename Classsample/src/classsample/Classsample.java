/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classsample;

public class Classsample {

    public static void main(String[] args) {
        int x = 5;
        Book myFirstBook = new Book(4.5, "Thinking in Java");
        myFirstBook.print();

        Book mySecondBook = new Book(5.6, "Алгоритми");
        mySecondBook.print();
       // mySecondBook.price = 10.123;
     //   System.out.println("Price is:" + mySecondBook.price);
        
        mySecondBook.setPrice(123);
        System.out.println(mySecondBook.getPrice());

        Book y = new Book(20.5, "werb in Java");
        y.print();
        double total = mySecondBook.calc(7);
        System.out.println(total);
    }

}
