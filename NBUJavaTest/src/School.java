import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class School {

    private String name;
    private long fnum;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getFnum() {
        return fnum;
    }

    public void setFnum(long fnum) {
        this.fnum = fnum;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", fnum=" + fnum +
                '}';
    }
}