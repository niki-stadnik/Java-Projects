package XMLreader;

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

public class Demo {

    public static void main(String[] args) {
        Set<Student> students = new TreeSet<>(Comparator.comparingLong(Student::getFnum).thenComparing(Student::getName));
        JAXBContext jc = null;
        try {
            jc = JAXBContext.newInstance(Student.class);
            Unmarshaller unmarshaller = jc.createUnmarshaller();
            XMLInputFactory xif = XMLInputFactory.newFactory();
            XMLStreamReader xsr = xif.createXMLStreamReader(new FileReader("C:\\Users\\Unexpected\\Documents\\Test\\Java APPS\\src\\XMLreader\\students.xml"));
            xsr.nextTag();
            xsr.nextTag();
            while(xsr.hasNext()) {
                Student student = (Student) unmarshaller.unmarshal(xsr);
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
