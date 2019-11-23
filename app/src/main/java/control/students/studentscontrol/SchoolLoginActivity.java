package control.students.studentscontrol;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class SchoolLoginActivity extends AppCompatActivity {

    ArrayList<School> database = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_school_login);

        Button button = findViewById(R.id.sign_in);

        //init data (should be loaded from database)
        database.add(new School("Valera", "54"));
        School s = database.get(0);
        for (int i = 1; i <= 11; i++) {
            s.AddGrade(new Grade(i, 'A'));
            s.AddGrade(new Grade(i, 'B'));
        }

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText tLogin = findViewById(R.id.login);
                EditText tPasswd = findViewById(R.id.passwd);

                final String login = tLogin.getText().toString();
                final String passwd = tPasswd.getText().toString();

                School s = database.get(0);
                if (s.getLogin().equals(login) && s.getPasswd().equals(passwd)) {
                    Intent intent = new Intent(SchoolLoginActivity.this, MainActivity.class);
                    intent.putExtra("school", s);
                    startActivity(intent);
                }
                else {
                    AlertDialog.Builder builder = new AlertDialog.Builder(SchoolLoginActivity.this);
                    builder.setTitle("Error!")
                            .setMessage("Incorrect login or password")
                            .setNegativeButton("OK", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.cancel();
                                }
                            });
                    AlertDialog alertDialog = builder.create();
                    alertDialog.show();
                }
                Toast toast = Toast.makeText(SchoolLoginActivity.this, "Succesfully logged in as user " + s.getLogin(), Toast.LENGTH_LONG);
                toast.show();
            }
        });

    }
}
