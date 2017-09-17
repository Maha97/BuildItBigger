package maha.abdelshafy.com.jokesclient;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class JokeDisplay extends AppCompatActivity {
TextView jokeText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke_display);
        jokeText=(TextView) findViewById(R.id.joke_text_view);
        Intent intent=getIntent();
     String joke=intent.getStringExtra("joke");
        jokeText.setText(joke);
    }
}
