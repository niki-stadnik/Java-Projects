 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classsample;

public class Book {

    private double price;
    private String title;

    Book(double p, String t) {
        price = p;
        title = t;
    }
public void setPrice (double price){
    this.price = price;
}

public double getPrice(){
    return price;
}
    public void print() {
        System.out.printf("%1$3.2f   \"%2$s\"\n", price, title);
    }

    public double calc(int x) {
        return price * x;
    }
}
