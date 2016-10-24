package com.mindcalc.calc;

import java.util.ArrayList;

/**
 * Created by Mashkovsky on 13.10.2016.
 */
public class UserQuery {
    int numOfTasks;
    ArrayList<Signs> signs;
    int difficulty;
    int numOfVars;

    public UserQuery(int numOfTasks, ArrayList<Signs> signs, int difficulty, int numOfVars){
        this.numOfTasks = numOfTasks;
        this.difficulty = difficulty;
        this.signs = signs;
        this.numOfVars = numOfVars;
    }

    public String make(){
        String text = "<!DOCTYPE html>\n" +
                "<html>\n" +
                "<head>\n" +
                "<title>Устный счет</title>\n" +
                "</head>\n" +
                "<body style=\"font-family: Baskerville, Cambria, Georgia;\">\n";
        for (int ivar = 0; ivar < numOfVars; ivar++) {
            text += "<h2><center>\n" +
                    "Вариант "+ (ivar+1) + "\n" +
                    "</center></h2> ";
            text += "<table>\n";
            for (int i = 0; i < numOfTasks; i++) {
                text += "<tr>\n";
                int counter = 0;
                for (Signs sign :
                        signs) {
                    text += "<td><b>";
                    text += (counter * numOfTasks + i + 1);
                    text += ".</b></td><td width=\"100px\">";
                    Task tempTask = new Task(sign, difficulty);
                    text += tempTask;
                    text += "</td><td>=</td><td width=\"50px\" color=black style=\"border: 1px solid black; padding: -5px\"><b>";
                    text += tempTask.getResult();
                    text += "</b></td><td>  </td>\n";
                    counter += 1;
                }
                text += "</tr>\n";
            }
            text += "</table><br>\n";
        }
        text += "</body>\n" +
                "</html>";
        return text;
    }
}
