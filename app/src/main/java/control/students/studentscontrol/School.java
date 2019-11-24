package control.students.studentscontrol;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayDeque;
import java.util.ArrayList;


public class School implements Parcelable {
    private String login;
    private String passwd;
    //private ArrayDeque<Grade> grades; //should be hashmap?
    private ArrayList<Grade> grades;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(login);
        dest.writeString(passwd);
        dest.writeArray(grades.toArray());
    }

    public static final Parcelable.Creator<School> CREATOR = new Parcelable.Creator<School>() {
        @Override
        public School createFromParcel(Parcel source) {
            return new School(source);
        }

        @Override
        public School[] newArray(int size) {
            return new School[size];
        }
    };

    public School(String login, String passwd) {
        this.login = login;
        this.passwd = passwd;
        this.grades = new ArrayList<>();
        //this.grades = new ArrayDeque<Grade>();
    }

    public School(Parcel in) {
        this.login = in.readString();
        this.passwd = in.readString();
        //this.grades = new ArrayDeque<Grade>(in.readArrayList(Grade.class.getClassLoader()));
        this.grades = in.readArrayList(Grade.class.getClassLoader());
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

    //Trying to make hashmap :)

    private final int HASH_CAPACITY = 26*11; // 11 grades, 26 latin letters
}
