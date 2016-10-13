package com.mindcalc.calc;

import java.util.ArrayList;

/**
 * Created by Mashkovsky on 13.10.2016.
 */
public class UserQuery {
    int numOfTasks;
    ArrayList<Signs> signs;
    int difficulty;

    public UserQuery(int numOfTasks, ArrayList<Signs> signs, int difficulty){
        this.numOfTasks = numOfTasks;
        this.difficulty = difficulty;
        this.signs = signs;
    }

    public ArrayList<Task> make(){
        ArrayList<Task> listOfTasks = new ArrayList<Task>();
        for (Signs sign :
                this.signs) {
            for (int i = 0; i < numOfTasks; i++) {
                listOfTasks.add(new Task(sign, difficulty));
            }
        }
        return listOfTasks;
    }
}
