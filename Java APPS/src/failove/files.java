package failove;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class files {
    public static void main(String[] args) {
        try (Writer wr = new FileWriter("myfile.txt")) {    // ako ne oto4nim lokaciq se zapazva  v papkata na proekta koqto moje da se proveri kato se zadurji mi6kata gore na imeto na proekta

            wr.write("Hallo! \r\n");   // za windows fail kato notepad trqbva da se pizpi6e \r\n za da premine na nov red

            wr.write("How are you?\n");   // za mak linux i tn moje da se napi6e samo \n (notepad ++ 4ete si4ki varianti)

            wr.write("Zdrasti!" + System.lineSeparator());  //ako polzvame tozi metod toi se razpoznava kato nov red ot vsi4ki

            wr.write("Zdravei otnovo");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
