package com.mindcalc.calc;
import com.mindcalc.tools.*;
/**
 * Created by Mashkovsky on 13.10.2016.
 */
public class Task {
    double n1;
    double n2;
    private double result;
    Signs sign;
    int difficulty;

    public Task(Signs sign, int difficulty){
        double[] temp;
        switch (sign){
            case PLUS:
                temp = GenTask.GenTwoNumbersForSum(difficulty);
                break;
            case MINUS:
                temp = GenTask.GenTwoNumbersForMinus(difficulty);
                break;
            case MUL:
                temp = GenTask.GenTwoNumbersForMul(difficulty);
                break;
            case DIV:
                temp = GenTask.GenTwoNumbersForDiv(difficulty);
                break;
            default:
                temp = GenTask.GenTwoNumbersForSum(difficulty);
                break;
        }
        this.n1 = temp[0];
        this.n2 = temp[1];
        this.result = temp[2];
        this.sign = sign;
        this.difficulty = difficulty;
    }

    public String toString(){
        String output = "";
        output += DoubleOut.clean(n1);
        output += " ";
        switch (sign){
            case PLUS:
                output += "+ ";
                break;
            case MINUS:
                output += "- ";
                break;
            case MUL:
                output += "· ";
                break;
            case DIV:
                output += ": ";
                break;
            default:
                output += "*MAGIC* ";
                break;
        }
        output += DoubleOut.clean(n2);
        return output;
    }

    public String getResult() {
        return DoubleOut.clean(result);
    }
}
