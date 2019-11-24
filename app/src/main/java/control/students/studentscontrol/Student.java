package control.students.studentscontrol;

import android.os.Parcel;
import android.os.Parcelable;

public class Student implements Parcelable {
    private String firstname; //имя
    private String secondname; //отчество
    private String lastname; //фамилия

    public Student(String firstname, String secondname, String lastname) {
        this.firstname = firstname;
        this.secondname = secondname;
        this.lastname = lastname;
    }

    public Student(Parcel in) {
        this.firstname = in.readString();
        this.secondname = in.readString();
        this.lastname = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(firstname);
        dest.writeString(secondname);
        dest.writeString(lastname);
    }

    public static final Parcelable.Creator<Student> CREATOR = new Parcelable.Creator<Student>() {
        @Override
        public Student createFromParcel(Parcel source) {
            return new Student(source);
        }

        @Override
        public Student[] newArray(int size) {
            return new Student[size];
        }
    };

    public String getFullName() { return firstname + " " + secondname + " " + lastname; }
}
