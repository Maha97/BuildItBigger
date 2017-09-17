package com.udacity.gradle;

import android.support.test.runner.AndroidJUnit4;

import com.udacity.gradle.builditbigger.RetrieveJokeTask;

import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class JokeTest {

    @Test
    public void testJoke(){
        RetrieveJokeTask jokeTask=new RetrieveJokeTask();
        jokeTask.execute();
        try{
            String joke=jokeTask.get();
            assert !joke.equals(null);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}