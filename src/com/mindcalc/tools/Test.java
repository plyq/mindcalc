package com.mindcalc.tools;

/**
 * Created by Mashkovsky on 13.10.2016.
 */
public class Test {
    public static void main(String[] args) {
        for (int i = 1; i <= 5; i++) {
            double[] output = GenTask.GenTwoNumbersForSum(i);
            System.out.println("Level "+i+": "+output[0]+" + "+output[1]+" =");
            output = GenTask.GenTwoNumbersForMinus(i);
            System.out.println("Level "+i+": "+output[0]+" - "+output[1]+" =");
            output = GenTask.GenTwoNumbersForMul(i);
            System.out.println("Level "+i+": "+output[0]+" * "+output[1]+" =");
            output = GenTask.GenTwoNumbersForDiv(i);
            System.out.println("Level "+i+": "+output[0]+" / "+output[1]+" =");
        }
        System.out.println(DoubleOut.clean(12000.23000000004));
    }
}
