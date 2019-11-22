package control.students.studentscontrol;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    School school;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        school = new School("Valera", "54");
        school.AddGrade(new Grade(1, 'A'));

        ListView listView_Grades = findViewById(R.id.listview_grades);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.grade_item, R.id.text_grade, school.getGradesStrings());
        listView_Grades.setAdapter(adapter);

        Button addGrade = findViewById(R.id.add_grade);

        addGrade.setOnClickListener(new View.OnClickListener() { //DOES NOT LOOK LIKE OOP (separate class Dialog solution?)
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("New Grade")

                        .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        });
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }
        });
    }
}
