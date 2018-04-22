package app.cool.dz.coolapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

import app.cool.dz.coolapp.db.DataBasePostsHelper;

public class TodosActivity extends AppCompatActivity {
    ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todos);
        list = (ListView)findViewById(R.id.list);

        DataBasePostsHelper db = new DataBasePostsHelper(getBaseContext());

        List<String> todosList = db.list();
        Log.i("list",""+todosList.toString());

        list.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,todosList));
    }
}
