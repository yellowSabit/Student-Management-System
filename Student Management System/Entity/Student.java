package Entity;

import javax.swing.*;
import java.io.*;

public class Student extends Person {

    private String department;
    private String semester;
    private String cgpa;

    public Student(String name, String id, String department,
                   String semester, String cgpa) {
        super(name, id);
        this.department = department;
        this.semester   = semester;
        this.cgpa       = cgpa;
    }

    public void setDepartment(String department) 
	{ this.department = department; }
    public void setSemester(String semester)     
	{ this.semester = semester; }
    public void setCgpa(String cgpa)  
	{ this.cgpa = cgpa; }

    public String getDepartment()
	{ return department; }
    public String getSemester()
	{ return semester; }
    public String getCgpa()
	{ return cgpa; }

 
    public String getInfo() {
        return "Name:" +getName() + " ,ID:" + getId() + ",Department:" + getDepartment();
    }

    public void insertInfo() {
        try {
            File file = new File("userdata.txt");
            FileWriter fw = new FileWriter(file, true);
            fw.write("========================================\n");
            fw.write("Name: "       + getName()    + "\n");
            fw.write("ID: "         + getId()      + "\n");
            fw.write("Department: " + department   + "\n");
            fw.write("Semester: "   + semester     + "\n");
            fw.write("CGPA: "       + cgpa         + "\n");
            fw.write("----------------------------------------\n");
            fw.flush();
            fw.close();
        }
        catch(IOException ioe) {
            ioe.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error saving file!");
        }
    }
}