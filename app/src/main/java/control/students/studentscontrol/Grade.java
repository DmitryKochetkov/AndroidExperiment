package control.students.studentscontrol;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class Grade implements Parcelable {
    public String name;
    //ArrayList<Student> students;

    public Grade(int number, char letter) {
        this.name = "Grade " + number + letter;
    }

    public Grade(Parcel in) {
        this.name = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
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
}
