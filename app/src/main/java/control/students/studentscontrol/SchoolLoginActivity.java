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

    ArrayList<School> database = new ArrayList<School>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_school_login);

        Button button = (Button) findViewById(R.id.school_login_button);

        database.add(new School("Valera", "54"));

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText tLogin = (EditText) findViewById(R.id.login);
                EditText tPasswd = (EditText) findViewById(R.id.passwd);

                final String login = tLogin.getText().toString();
                final String passwd = tPasswd.getText().toString();

                School s = database.get(0);
                if (s.getLogin() != login && s.getPasswd() != passwd) {
                    Intent intent = new Intent(SchoolLoginActivity.this, MainActivity.class);
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
                Toast toast = Toast.makeText(SchoolLoginActivity.this, "Data: " + s.getLogin() + " " + s.getPasswd() + ", fields: " + login + " " + passwd, Toast.LENGTH_LONG);
                toast.show();
            }
        });

    }
}
