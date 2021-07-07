package Hotel;

public class Sauna {
    private int free;
    public int freeMax;
    int genderIN = 2;
    int jam = 2;
    int counter = 0;
    int prevGender = 2;
    int flag = 0;

    Sauna(int free) {
        this.free = free;
        freeMax = free;
    }

    synchronized void takeSauna(int gender) {
        if (free == freeMax) genderIN = gender;
        while (free == 0 || genderIN != gender || flag == 1) {
            if (genderIN != gender && counter==2) {
                flag = 1;
                if (genderIN == 1 && free == 2) genderIN = 0;
                else if (genderIN == 0 && free == 2) genderIN = 1;
            }
            System.out.println("saunata e zaeta, " + Thread.currentThread().getName() + " waiting");
            try {
                wait();
            } catch (InterruptedException e) {
                System.err.println(e);
            }
            if (free == freeMax) genderIN = gender;
            if (free == freeMax) flag = 0;

        }
        free--;
        if (prevGender != gender) {
            counter = 0;
            flag = 0;
        } else counter++;
        prevGender = gender;
        System.out.println("v saunata vleze " + Thread.currentThread().getName() + ", ima " + free + " svobodni mesta");
    }

    synchronized void releaseSauna() {
        free++;
        System.out.println("saunata e osvobodena ot " + Thread.currentThread().getName() + ", ima " + free + " svobodni mesta");
        notifyAll();
    }
}
