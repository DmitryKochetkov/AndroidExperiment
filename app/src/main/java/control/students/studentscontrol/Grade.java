package control.students.studentscontrol;

import java.util.ArrayList;

public class Grade {
    private int number;
    private char letter;
    public String name;
    ArrayList<Student> students;

    public Grade(int number, char letter) {
        this.number = number;
        this.letter = letter;
        this.name = "Grade " + Integer.toString(number) + Character.toString(letter);
    }
}
