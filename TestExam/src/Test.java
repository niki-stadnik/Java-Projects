//Клас Тест – съхранява информация за тест, който се състои от: брой въпроси, които се включват
//в теста и списък с въпроси от тип многовариантен избор.

import java.util.concurrent.ThreadLocalRandom;

class Test {

    //Метод за генериране на тест, с въпроси, които са подбрани на случаен принцип. Броят
    //на въпросите, и списъкът с въпроси, от който те са избрани се предават като аргумент
    //на метода;
    static int[] generate(int broiVuprosi, int sushtestvuvashtiVaprosi) {
        int[] spisak = new int[broiVuprosi];
        boolean flag = false;
        for (int i = 0; i < broiVuprosi; i++) {
            int randomNum = ThreadLocalRandom.current().nextInt(1, sushtestvuvashtiVaprosi + 1);
            for (int j = 0; j < i; j++) {
                if (spisak[j] == randomNum) {
                    flag = true;
                }
            }
            if (flag) {
                i--;
                flag = false;
            } else spisak[i] = randomNum;
        }
        return spisak;
    }
}
