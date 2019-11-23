package control.students.studentscontrol;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class School implements Parcelable {
    private String login;
    private String passwd;
    private ArrayList<Grade> grades; //should be dequeue? doesn't work for classes A, B and so on yet

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
    }

    public School(Parcel in) {
        this.login = in.readString();
        this.passwd = in.readString();
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
}
