package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Pair;
import android.widget.Toast;

import com.abdelshafy.maha.myapplication.backend.myApi.MyApi;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;

import java.io.IOException;

/**
 * Created by 007 on 25/07/2017.
 */
public class RetrieveJokeTask extends AsyncTask<Void,Void,String> {


    private static MyApi myApiService=null;
    private Context context;

    @Override
    protected String doInBackground(Void... params) {
        if(myApiService==null){
            //Only do this once
            MyApi.Builder builder=new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(),null).setRootUrl("http://MahaApplicationId.appspot.com/_ah/api")
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> request) throws IOException {
                            request.setDisableGZipContent(true);


                        }
                    });
            myApiService=builder.build();

        }

        try{
            return myApiService.getJoke().execute().getData();
        }catch(IOException e){
            return e.getMessage();

        }
    }
    @Override
    protected void onPostExecute(String result) {
       if(result!=null){
           MainActivity.showJoke(result);
       }else{
           Toast.makeText(context,"Sorry,There is No Joke!",Toast.LENGTH_LONG).show();
       }

    }
}
