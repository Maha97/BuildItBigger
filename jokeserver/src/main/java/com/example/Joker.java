package com.example;

import java.util.ArrayList;
import java.util.Random;

public class Joker {
    private ArrayList<String> jokesList=new ArrayList<>();

    public Joker(){
        jokesList.add("Why did the physics teacher break up with the biology teacher?There was no chemistry");
        jokesList.add("Hey there i am a very funny Joke");
        jokesList.add("what is  the worst thing about being lonely? playing Frisbee");

        jokesList.add("HaHaaaha");

    }
    public  String getJokeFromJokerClass(){
        Random rand=new Random();
        int randomElementIndex=rand.nextInt(jokesList.size());
        String randomElement=jokesList.get(randomElementIndex);
        return randomElement;
    }
}
