package control.students.studentscontrol;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    School school;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        school = new School("Valera", "54");
        school.AddGrade(new Grade("Grade 1A"));

        ListView listView_Grades = findViewById(R.id.listview_grades);
        ArrayAdapter<Grade> adapter = new ArrayAdapter<Grade>(this, R.layout.grade_item, R.id.text_grade, school.getGrades());
        listView_Grades.setAdapter(adapter);
    }
}
