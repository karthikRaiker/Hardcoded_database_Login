package com.example.exma6hardcode;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button login,cancel;
    EditText uname,password;
    DBhandler db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        login = findViewById(R.id.login);
        cancel = findViewById(R.id.cancel);
        uname = findViewById(R.id.usernm);
        password = findViewById(R.id.passwd);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String unm = uname.getText().toString();
                String pwd = password.getText().toString();
                int id = checkUser(new User(unm, pwd));
                if(id==-1)
                {
                    Toast.makeText(getApplicationContext(),"no user found",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"user found "+unm,Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(MainActivity.this,Main2Activity.class);
                    startActivity(i);
                }
            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        db = new DBhandler(MainActivity.this);
        db.adduser(new User("admin","password"));
        db.adduser(new User("karthik","raiker"));
        db.adduser(new User("hello","world"));
        db.adduser(new User("rvce","bangalore"));
    }

    public int checkUser(User user)
    {
        return db.checkUser(user);
    }
}
