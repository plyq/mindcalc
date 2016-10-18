package com.mindcalc.tools;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

/**
 * Created by Mashkovsky on 13.10.2016.
 */
public class DoubleOut {
    public static String clean(double d){
        NumberFormat format = NumberFormat.getInstance(Locale.getDefault());
        Number number = null;
        try {
            number = format.parse(String.format(Locale.getDefault(), "%.8f%n", d));
        } catch (ParseException e) {
            System.out.println("smth go wrong");
        }
        double dAfterBug = number.doubleValue();
        String lol = String.valueOf(dAfterBug);

        lol = lol.replace('.','~');
        int rightPart = Integer.parseInt(lol.split("~")[1]);
        int leftPart = Integer.parseInt(lol.split("~")[0]);
        if (rightPart > 0){
            return leftPart + "," + rightPart;
        } else {
            return "" + leftPart;
        }

    }
}
