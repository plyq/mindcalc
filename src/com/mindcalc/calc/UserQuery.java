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

    public String make(){
        String text = "<html>\n";
        text += "<table>\n";
        for (int i = 0; i < numOfTasks; i++)
        {
            text += "<tr>\n";
            int counter = 0;
            for (Signs sign :
                    signs) {
                text += "<td>";
                text += (counter * numOfTasks + i + 1);
                text += ".</td><td>";
                Task tempTask = new Task(sign, difficulty);
                text += tempTask;
                text += "</td><td>=</td><td>";
                text += tempTask.getResult();
                text += "</td><td>  </td>\n";
                counter += 1;
            }
            text += "</tr>\n";
        }
        text += "</table>\n";
        return text;
    }
}
