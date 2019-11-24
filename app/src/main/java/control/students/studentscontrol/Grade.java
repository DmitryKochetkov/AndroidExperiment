package control.students.studentscontrol;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class Grade implements Parcelable {
    public String name;
    ArrayList<Student> students;

    public Grade(int number, char letter) {
        this.name = "Grade " + number + letter;
        this.students = new ArrayList<>();
        //debug feature
        for (int i = 0; i < 5; i++)
            students.add(new Student(NameGenerator.getRandomFirstName(), NameGenerator.getRandomSecondName(), NameGenerator.getRandomLastName()));
    }

    public Grade(Parcel in) {
        this.name = in.readString();
        this.students = in.readArrayList(Student.class.getClassLoader());
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeArray(students.toArray());
    }

    public static final Parcelable.Creator<Grade> CREATOR = new Parcelable.Creator<Grade>() {
        @Override
        public Grade createFromParcel(Parcel source) {
            return new Grade(source);
        }

        @Override
        public Grade[] newArray(int size) {
            return new Grade[size];
        }
    };

    public ArrayList<String> getStudentsStrings() {
        ArrayList<String> res = new ArrayList<>();
        for (Student s: students) { res.add(s.getFullName()); }
        return res;
    }
}
