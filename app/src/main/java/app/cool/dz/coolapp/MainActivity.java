package app.cool.dz.coolapp;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

import app.cool.dz.coolapp.db.DataBasePostsHelper;

public class MainActivity extends AppCompatActivity {

    EditText todaName;
    FloatingActionButton addBtn,listBtn;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        todaName = (EditText) findViewById(R.id.todoName);
        addBtn = (FloatingActionButton)findViewById(R.id.addBtn);
        listBtn = (FloatingActionButton)findViewById(R.id.listBtn);

        listBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),TodosActivity.class));
            }
        });

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.i("btn_log","click");
                String todoText =  todaName.getText().toString();
                DataBasePostsHelper db = new DataBasePostsHelper(getBaseContext());
                db.add(todoText);
                Toast.makeText(getBaseContext(),"insertion de données dans la table todos",Toast.LENGTH_LONG).show();


            }
        });


    }
}
