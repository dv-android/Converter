package com.hfad.converter;

import android.content.Intent;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.AdapterView;
import android.view.View;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import java.util.ArrayList;
import android.widget.Toast;
import android.util.Log;
import static android.R.id.list;

public class MainActivity extends Activity {
      ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.e("Main Activity", "Host Started");

        listView = (ListView) findViewById(R.id.listview);
        String[] values = new String[]{"Currency", "Areaa", "Temprature"};
        View listViewRow;
        ArrayList<String> list = new ArrayList<String>();

        for (int i = 0; i < values.length; i++) {
            list.add(values[i]);
        }

        final ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new OnItemClickListener()
        {
            public void onItemClick(AdapterView<?> parent, View
                    view,int position, long id)
            {

                Log.e("Main Activity", "Row clicked");
                Intent intent = new Intent(getApplicationContext(),ConvertDataActivity.class);
                intent.putExtra("rowNo",position);

                startActivity(intent);
// When clicked, show a toast with the TextView text
                //Toast.makeText(getApplicationContext(), ((TextView)
                 ///       view).getText(),Toast.LENGTH_SHORT).show();
            }
        });
    }

    protected void onStart(){
        super.onStart();

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.activity_main_actions, menu);

        return super.onCreateOptionsMenu(menu);
    }
}
