package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import maha.abdelshafy.com.jokesclient.JokeDisplay;

public class MainActivity extends AppCompatActivity {
    private static ProgressBar mProgressBar;
   private  ConnectionDetector cd;
    private boolean isConnectedToInternt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cd=new ConnectionDetector(this);
        isConnectedToInternt=cd.isConnectingToInternet();
       mProgressBar= (ProgressBar) findViewById(R.id.progress_bar);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void tellJoke(View view) {
        if(isConnectedToInternt){
       new RetrieveJokeTask().execute();
       mProgressBar.setVisibility(View.VISIBLE);

     }else   {
        Toast.makeText(this, "There is No Network,Please check your  Internet Connection", Toast.LENGTH_SHORT).show();
    }
    }

public static void showJoke(String joke){

    try{
        Context mContext=mProgressBar.getContext();
        mProgressBar.setVisibility(View.GONE);
        Intent intent=new Intent(mContext,JokeDisplay.class);
        intent.putExtra("joke",joke);
       mContext.startActivity(intent);


    }catch(NullPointerException e){
        e.printStackTrace();
    }
}



}
