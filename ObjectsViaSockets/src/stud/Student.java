package stud;
import java.io.*;
import javax.swing.*;


class Person implements Serializable{
    private static final long serialVersionUID = 1L;
    String name="";
    String id="";
    public Person(){
        do{
            name = JOptionPane.showInputDialog("Please enter person's name");
        } while((name == null)|| (name.length()==0));

        do{
            id = JOptionPane.showInputDialog("Please enter person' id");
        } while((id == null)|| (id.length()==0));

    }
    public String toString(){
        return name+" "+id+" ";
    }
}

public class Student extends Person{
    private static final long serialVersionUID = 1L;
    int marks[];
    public Student(){
        marks = new int[5];
        for(int i=0;i<marks.length;i++){
            do{
                String s = JOptionPane.showInputDialog("Please enter marks "+(i+1)+" [0 - 6]");
                if(s==null)s="0";       //to terminate input with cancel
                try{
                    marks[i]= Integer.parseInt(s);
                }
                catch(Exception e){marks[i]=7;}
            } while((marks[i]<0)|| (marks[i]>6));
            if(marks[i]==0)break;
        }
    }
    public String toString(){
        String s = super.toString()+" marks: ";
        for(int i=0;i<marks.length;i++){
            if(marks[i]==0) break;
            s+=marks[i]+" ";
        }
        return s;
    }
    public String getName(){
        return this.name;
    }
}