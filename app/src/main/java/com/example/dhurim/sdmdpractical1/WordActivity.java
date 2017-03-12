package com.example.dhurim.sdmdpractical1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class WordActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_word);
        Bundle wordExtras = getIntent().getExtras();
        if(wordExtras == null)
            return;
        String chosenLanguage = wordExtras.getString(MainActivity.EXTRA_LANGUAGE);
        Toast.makeText(WordActivity.this, chosenLanguage, Toast.LENGTH_LONG).show();

    }
    public void onClickBack(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
    //TODO(2) Add hard-coded resources
    //TODO(3) Implement button onclick for each button
}
