/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package student_entry;

/**
 *
 * @author Abood Sh
 */
public class Student implements Comparable {
    int id ; 
    String name ; 
    String major ; 
    double grade ; 

    public Student(int id, String name, String major, double grade) {
        this.id = id;
        this.name = name;
        this.major = major;
        this.grade = grade;
    }
   
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
       String f = " ";
            f = String.format("%-" + (15 - String.valueOf(id).length()) + "d"
                    + "%-" + (15 - name.length()) + "s"
                    + "%-" + (15 - major.length()) + "s"
                    + "%-2.2f",
                    id, name, major,grade
            );
        return f;
    }

    @Override
    public int compareTo(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
