package Generics;

public class MyListApp {
    public static void main(String[] args) {
        MyList<String> listStr = new MyList<>();

        listStr.set(0, "hello");

        System.out.println(listStr.get(0));

        MyList<Integer> listInt = new MyList<>();

        listInt.set(0, 42);

        System.out.println(listInt.get(0));
    }
}

class MyList<T> {

    private Object[] items = new Object[10];

    public void set(int i, T item) {
        items[i] = item;
    }
    public T get(int i) {
        return (T) items[i];
    }
}