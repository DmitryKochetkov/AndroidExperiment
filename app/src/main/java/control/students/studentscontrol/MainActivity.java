package control.students.studentscontrol;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    School school;
    Spinner sNumbers;
    Spinner sLetters;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.add_grade: {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

                Integer[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
                //final Spinner sNumbers = findViewById(R.id.spinner_numbers);

                Character[] letters = {'A', 'B', 'C'};
                //final Spinner sLetters = findViewById(R.id.spinner_letters);

                ArrayAdapter<Integer> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, numbers);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

                if (sNumbers == null)
                    Log.d("MainActivity", "sNumbers is null");

                sNumbers.setAdapter(adapter); //null reference exception
                sLetters.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, letters));

                builder.setTitle("New Grade")
                        .setView(R.layout.new_grade_dialog)
                        .setPositiveButton("Add Grade", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                school.AddGrade(new Grade((Integer)sNumbers.getSelectedItem(), (Character)sLetters.getSelectedItem()));
                            }
                        })
                        .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                school.AddGrade(new Grade(3, 'C'));
                            }
                        });
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
                return true;
            }

            case R.id.graduate: {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Graduation")
                        .setMessage("This feature allows you to start a new academic year. Use it to shift all grades (e.g. 1A to 2A, 2A to 3A and so on).")
                        .setPositiveButton("Start new year", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                //shift
                            }
                        })
                        .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        });
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
                return true;
            }

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //school = (School) getIntent().getExtras().get("school");
        school = getIntent().getExtras().getParcelable("school");

        ListView listView_Grades = findViewById(R.id.listview_grades);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.grade_item, R.id.text_grade, school.getGradesStrings()); //change to my own adapter?
        listView_Grades.setAdapter(adapter);

        listView_Grades.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, GradeActivity.class);
                //transfer class
                startActivity(intent);
            }
        });

        sNumbers = findViewById(R.id.spinner_numbers);
        sLetters = findViewById(R.id.spinner_letters);
    }
}
