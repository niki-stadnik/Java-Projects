package SpisakAvtomobili;


public class Avtomobil implements Comparable<Avtomobil>{
    private double price;
    private String brand;
    private int year;

    public Avtomobil(double price, String brand, int year) {
        this.price = price;
        this.brand = brand;
        this.year = year;
    }

    public double getRice() {
        return price;
    }

    public String getBrand() {
        return brand;
    }

    public int getYear() {
        return year;
    }


    
    @Override
    public int compareTo(Avtomobil o) {

        if(this.price==o.price){
            if(this.year==o.year){
                return this.brand.compareTo(o.brand);
            }
            return Integer.compare(this.year,o.year);

        }
        return Double.compare(this.price,o.price);
    }

    @Override
    public String toString() {
        return "Avtomobil{" +
                "price=" + price +
                ", brand='" + brand + '\'' +
                ", year=" + year +
                '}';
    }
}
