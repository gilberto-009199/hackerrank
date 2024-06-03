package algoritm;


import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

import static java.lang.System.out;


// https://www.hackerrank.com/challenges/time-conversion/problem

public class TimeConversion {

	/*
     * Complete the 'timeConversion' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String timeConversion(String s) {
        //  hh:mm:ss(AM|PM)
        //  12:01:00PM ~> 12:01:00
        //  12:01:00AM ~> 00:01:00
        int hh = Integer.parseInt( s.substring(0, 2) );
        int mm = Integer.parseInt( s.substring(3, 5) );
        int ss = Integer.parseInt( s.substring(6, 8) );
        boolean AM_PM = s.substring(8, 10).equals("AM");
        
        // Given a time in -hour AM/PM format, convert it to military (24-hour) time.
        // Note: - 12:00:00AM on a 12-hour clock is 00:00:00 on a 24-hour clock.
        //       - 12:00:00PM on a 12-hour clock is 12:00:00 on a 24-hour clock.
        
        // Hipotese: PM && horas < 12           LOGO +12 horas
        //  10:00:00PM ~> 12 + 10 == 22:00:00 
        //  01:00:00PM ~> 12 + 01 == 13:00:00 
        //  12:01:00PM ~>      12 == 12:01:00
        //  07:05:45PM ~> 12 + 07 == 19:05:00
        boolean isPMAndLess12Hrs = !AM_PM && hh < 12;  
        if(isPMAndLess12Hrs) {
        	hh += 12;
        }
        // Hipotese: AM && horas >= 12          LOGO -12 horas
        //  10:00:00AM ~> 10        == 10:00:00 
        //  01:00:00AM ~> 01        == 01:00:00 
        //  12:00:00AM ~> -12 + 12  == 00:00:00 
        //  13:02:00AM ~> -12 + 13  == 01:02:00 
        boolean isAMAndGreatedOrEqual12Hrs = AM_PM && hh >= 12;
        if(isAMAndGreatedOrEqual12Hrs) {
        	hh -= 12;
        }
        
        // Format
        return (
        		(hh > 9 ? hh : "0"+hh)
        		+":"+
        		(mm > 9 ? mm : "0"+mm)
        		+":"+
        		(ss > 9 ? ss : "0"+ss)
        );
    }

    public static void main(String[] args) throws IOException {
    	
    	BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String result = TimeConversion.timeConversion(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
