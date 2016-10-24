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
        String rightpartStr = lol.split("~")[1];
        String leftpartStr = lol.split("~")[0];

        long rightPart;
        long leftPart;
        leftPart = Long.parseLong(leftpartStr);
        try{
            rightPart = Long.parseLong(rightpartStr);
        } catch (NumberFormatException e) {
            int tempBeforeE = Integer.parseInt(rightpartStr.split("E")[0]);
            int tempAfterE = Integer.parseInt(rightpartStr.split("E")[1]);
            int digits=0;
            int tempBeforeECopy = tempBeforeE;
            while (tempBeforeECopy > 0){
                digits += 1;
                tempBeforeECopy = tempBeforeECopy / 10;
            }
            for (int i = 0; i < digits; i++) {
                leftPart *= 10;
            }
            leftPart += tempBeforeE;
            for (int i = 0; i < (tempAfterE-digits); i++) {
                leftPart *= 10;
            }
            rightPart = 0;
            rightpartStr = String.valueOf(rightPart);
            leftpartStr = String.valueOf(leftPart);
        }

        if (rightPart > 0){
            return leftpartStr + "," + rightpartStr;
        } else {
            return "" + leftpartStr;
        }

    }

}
