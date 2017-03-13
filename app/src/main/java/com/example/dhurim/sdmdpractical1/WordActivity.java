package com.example.dhurim.sdmdpractical1;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Field;
import java.util.Random;

public class WordActivity extends AppCompatActivity {
    String[] wordList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_word);
        Bundle wordExtras = getIntent().getExtras();
        if(wordExtras == null)
            return;
        String chosenLanguage = wordExtras.getString(MainActivity.EXTRA_LANGUAGE);
        int languageId = getResources().getIdentifier(chosenLanguage,"array",getPackageName());
        wordList = getResources().getStringArray(languageId);
        Button one = (Button) this.findViewById(R.id.soundButton);
        int rn = random(wordList.length);
        final MediaPlayer mp = MediaPlayer.create(this, getSound(wordList[rn]));
        //TODO(5)  Displaying a button which should play the pronunciation of the random foreign word or phrase in the chosen language when clicked.(Play sound onClickSound)
        //TODO: select correct mp3 file for the displayed word
        one.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                mp.start();
            }
        });
        displayWord(R.id.wordText, R.id.wordImage, wordList[rn]);
    }
//COMPLETED(7)  Displaying a button which should take the user back to the language selection screen.
    public void onClickBack(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

//TODO(6)  Displaying a button which should provide a new random foreign word or phrase in the chosen language when clicked.
    public void onClickNext(View view){
        displayWord(R.id.wordText, R.id.wordImage, wordList[random(wordList.length)]);
    }

//COMPLETED(3)  Displaying a random useful foreign word or phrase on the Language Screen upon startup.
//COMPLETED(4)  Displaying an image accompanying the random foreign word or phrase.
public void displayWord(int textViewId, int imageViewId, String word){
    TextView wordText = (TextView) findViewById(textViewId);
    wordText.setText(word);
    ImageView wordImage = (ImageView) findViewById(imageViewId);
    wordImage.setBackgroundResource(getResources().getIdentifier(word,"drawable",getPackageName()));
}
public int getSound(String word){
    return getResources().getIdentifier(word,"raw",getPackageName());
}
public int random(int max){
    Random randomGenerator = new Random();
    return randomGenerator.nextInt(max);
}
}
