package com.mindcalc.tools;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Mashkovsky on 13.10.2016.
 */
public class GenTask {
    static ArrayList<Double> availNumsD1;
    static ArrayList<Double> availNumsD2;
    static ArrayList<Double> availNumsD3;

    static ArrayList<Double> availAddsD1;
    static ArrayList<Double> availAddsD2;

    static {
        availNumsD1 = new ArrayList<Double>();
        availNumsD2 = new ArrayList<Double>();
        availNumsD3 = new ArrayList<Double>();
        availAddsD1 = new ArrayList<Double>();
        availAddsD2 = new ArrayList<Double>();
        for (int i = 0; i < 10; i++) {
            availNumsD1.add((double) i);
        }
        for (int i = 10; i < 100; i++) {
            availNumsD2.add((double) i);
        }
        for (int i = 100; i < 1000; i++) {
            availNumsD3.add((double) i);
        }
        availAddsD1.add(10.0);
        availAddsD1.add(0.1);
        availAddsD2.add(10.0);
        availAddsD2.add(100.0);
        availAddsD2.add(0.1);
        availAddsD2.add(0.01);
    }

    public static double[] GenTwoNumbersForSum(int difficulty){
        double[] result = new double[3];
        ArrayList<Double> availNums= new ArrayList<Double>();
        ArrayList<Double> availAdds= new ArrayList<Double>();
        availAdds.add(1.0);
        switch (difficulty){
            case 1:
                availNums.addAll(availNumsD1);
                break;
            case 2:
                availNums.addAll(availNumsD1);
                availNums.addAll(availNumsD2);
                break;
            case 3:
                availNums.addAll(availNumsD1);
                availNums.addAll(availNumsD2);
                availAdds.addAll(availAddsD1);
                break;
            case 4:
                availNums.addAll(availNumsD1);
                availNums.addAll(availNumsD2);
                availAdds.addAll(availAddsD1);
                availAdds.addAll(availAddsD2);
                break;
            case 5:
                availNums.addAll(availNumsD1);
                availNums.addAll(availNumsD2);
                availNums.addAll(availNumsD3);
                availAdds.addAll(availAddsD1);
                availAdds.addAll(availAddsD2);
                break;
            default:
                availNums.addAll(availNumsD1);
                availNums.addAll(availNumsD2);
                availAdds.addAll(availAddsD1);
                break;
        }
        for (int i = 0; i < 2; i++) {
            Random random = new Random();
            result[i] = availNums.get(random.nextInt(availNums.size())) * availAdds.get(random.nextInt(availAdds.size()));
        }
        result[2] = result[0] + result[1];
        return result;
    }

    public static double[] GenTwoNumbersForMinus(int difficulty){
        double[] temp = GenTwoNumbersForSum(difficulty);
        double[] result = {
                temp[2],
                temp[1],
                temp[0]
        };
        return result;
    }

    public static double[] GenTwoNumbersForMul(int difficulty){
        double[] result = new double[3];
        ArrayList<Double> availNums1= new ArrayList<Double>();
        ArrayList<Double> availNums2= new ArrayList<Double>();
        ArrayList<Double> availAdds= new ArrayList<Double>();
        availAdds.add(1.0);
        switch (difficulty){
            case 1:
                availNums1.addAll(availNumsD1);
                availNums2.addAll(availNumsD1);
                break;
            case 2:
                availNums1.addAll(availNumsD1);
                availNums2.addAll(availNumsD1);
                availNums1.addAll(availNumsD2);
                break;
            case 3:
                availNums1.addAll(availNumsD1);
                availNums2.addAll(availNumsD1);
                availNums1.addAll(availNumsD2);
                availAdds.addAll(availAddsD1);
                break;
            case 4:
                availNums1.addAll(availNumsD1);
                availNums2.addAll(availNumsD1);
                availNums1.addAll(availNumsD2);
                availAdds.addAll(availAddsD1);
                availAdds.addAll(availAddsD2);
                break;
            case 5:
                availNums1.addAll(availNumsD1);
                availNums2.addAll(availNumsD1);
                availNums1.addAll(availNumsD2);
                availNums1.addAll(availNumsD3);
                availAdds.addAll(availAddsD1);
                availAdds.addAll(availAddsD2);
                break;
            default:
                availNums1.addAll(availNumsD1);
                availNums2.addAll(availNumsD1);
                availNums1.addAll(availNumsD2);
                availAdds.addAll(availAddsD1);
                break;
        }
        Random random = new Random();
        int whatsHarder = random.nextInt(2);
        switch (whatsHarder){
            case 0:
                result[0] = availNums1.get(random.nextInt(availNums1.size())) * availAdds.get(random.nextInt(availAdds.size()));
                result[1] = availNums2.get(random.nextInt(availNums2.size())) * availAdds.get(random.nextInt(availAdds.size()));
                break;
            case 1:
                result[1] = availNums1.get(random.nextInt(availNums1.size())) * availAdds.get(random.nextInt(availAdds.size()));
                result[0] = availNums2.get(random.nextInt(availNums2.size())) * availAdds.get(random.nextInt(availAdds.size()));
                break;
            default:
                result[0] = availNums1.get(random.nextInt(availNums1.size())) * availAdds.get(random.nextInt(availAdds.size()));
                result[1] = availNums2.get(random.nextInt(availNums2.size())) * availAdds.get(random.nextInt(availAdds.size()));
                break;
        }
        result[2] = result[0] * result[1];
        return result;
    }

    public static double[] GenTwoNumbersForDiv(int difficulty){
        double[] temp = GenTwoNumbersForMul(difficulty);
        double[] result = {
                temp[2],
                temp[1],
                temp[0]
        };
        return result;
    }
}
