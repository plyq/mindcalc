package com.mindcalc.tools;

import java.util.Locale;

/**
 * Created by Mashkovsky on 13.10.2016.
 */
public class DoubleOut {
    public static String clean(double d){
        double dAfterBug = Double.parseDouble(String.format(Locale.ENGLISH, "%(.8f", d));
        int leftPart = (int) dAfterBug;
        dAfterBug -= leftPart;
        int rightPart = 0;
        while (dAfterBug > 0){
            int temp = (int) (10.0 * dAfterBug);
            rightPart = rightPart * 10 + temp;
            dAfterBug -= temp;
        }
        return leftPart + "," + rightPart;
    }
}
