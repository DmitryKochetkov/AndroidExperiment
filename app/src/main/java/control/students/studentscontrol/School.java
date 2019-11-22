package control.students.studentscontrol;

import java.util.ArrayList;

public class School {
    private String login;
    private String passwd;
    private ArrayList<Grade> grades; //should be dequeue? doesn't work for classes A, B and so on yet

    public School(String login, String passwd) {
        this.login = login;
        this.passwd = passwd;
        grades = new ArrayList<Grade>();
    }

    public String getLogin() {
        return login;
    }

    public String getPasswd() {
        return passwd;
    }

    public ArrayList<Grade> getGrades() {
        return grades;
    }

    public ArrayList<String> getGradesStrings() {
        ArrayList<String> res = new ArrayList<>();
        for (Grade s: grades) { res.add(s.name); }
        return res;
    }

    public void AddGrade(Grade g) {
        grades.add(g);
    }
}
