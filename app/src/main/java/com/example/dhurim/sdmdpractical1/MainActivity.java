package com.example.dhurim.sdmdpractical1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_LANGUAGE = "language.to.use";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] languages = {"Albanian", "German"};
        ListAdapter languageAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, languages);
        ListView languageListView = (ListView) findViewById(R.id.language_list);
        languageListView.setAdapter(languageAdapter);

        languageListView.setOnItemClickListener(
                new AdapterView.OnItemClickListener(){
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        //TODO(1) Go to the next Activity, passing the language selected
                        String language = String.valueOf(parent.getItemAtPosition(position));
                        Intent intent = new Intent(MainActivity.this, WordActivity.class);
                        intent.putExtra(EXTRA_LANGUAGE,language);
                        startActivity(intent);
//                        Toast.makeText(MainActivity.this, language, Toast.LENGTH_LONG).show();
                    }
                }
        );
    }
}
