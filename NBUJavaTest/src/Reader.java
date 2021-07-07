import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class Reader {

    public static void main(String[] args) {
        Set<School> students = new TreeSet<>(Comparator.comparingLong(School::getFnum).thenComparing(School::getName));
        JAXBContext jc = null;
        try {
            jc = JAXBContext.newInstance(School.class);
            Unmarshaller unmarshaller = jc.createUnmarshaller();
            XMLInputFactory xif = XMLInputFactory.newFactory();
            XMLStreamReader xsr = xif.createXMLStreamReader(new FileReader("C:\\Users\\Unexpected\\Documents\\NBUJavaTest\\src\\School1.xml"));
            xsr.nextTag();
            xsr.nextTag();
            while(xsr.hasNext()) {
                School student = (School) unmarshaller.unmarshal(xsr);
                students.add(student);
                if(xsr.nextTag() != XMLStreamReader.START_ELEMENT) {
                    break;
                }
            }

            System.out.println(students);
        } catch (JAXBException | FileNotFoundException | XMLStreamException e) {
            e.printStackTrace();
        }
    }
}



//"C:\\Users\\Unexpected\\Documents\\NBUJavaTest\\src\\School1.xml"