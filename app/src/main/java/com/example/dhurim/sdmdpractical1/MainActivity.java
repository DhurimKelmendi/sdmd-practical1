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
//COMPLETED(1)  Selecting a foreign language from a drop down component.(with ListView)
        String[] languages = {"Albanian", "German"};
        ListAdapter languageAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, languages);
        ListView languageListView = (ListView) findViewById(R.id.language_list);
        languageListView.setAdapter(languageAdapter);

        languageListView.setOnItemClickListener(
                new AdapterView.OnItemClickListener(){
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        String language = String.valueOf(parent.getItemAtPosition(position));
//COMPLETED(2)  Navigating to a new screen (Language Screen) which knows about the selected foreign language(With intents, intent extras)
                        Intent intent = new Intent(MainActivity.this, WordActivity.class);
                        intent.putExtra(EXTRA_LANGUAGE,language);
                        startActivity(intent);
                    }
                }
        );
    }
}
