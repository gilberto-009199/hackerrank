package algoritm;

import java.io.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;

import static java.lang.System.in;
import static java.lang.System.out;

// https://www.hackerrank.com/challenges/java-datatypes/problem

public class JavaDataTypes {

	// -1 for signed + or - https://docs.oracle.com/javase/tutorial/java/nutsandbolts/datatypes.html
	private static BigInteger MIN_Byte	= BigInteger.valueOf(Byte.MIN_VALUE);
	private static BigInteger MAX_Byte	= BigInteger.valueOf(Byte.MAX_VALUE);

	private static BigInteger MIN_SHORT	= BigInteger.valueOf(Short.MIN_VALUE);
	private static BigInteger MAX_SHORT	= BigInteger.valueOf(Short.MAX_VALUE);

	private static BigInteger MIN_INT	= BigInteger.valueOf(Integer.MIN_VALUE);
	private static BigInteger MAX_INT	= BigInteger.valueOf(Integer.MAX_VALUE);

	private static BigInteger MIN_LONG	= BigInteger.valueOf(Long.MIN_VALUE);
	private static BigInteger MAX_LONG	= BigInteger.valueOf(Long.MAX_VALUE);

	public static int compareTo(BigInteger number, BigInteger numberCompare) {
		return number.compareTo( numberCompare );
	}
	
	public static void main(String args[]) {
		 	Scanner reader = new Scanner(in);

	        int lines = reader.nextInt();

	        for(int i = 0 ; i < lines; i++){
	            String s = reader.next();

	            BigInteger number = new BigInteger(s);

	            if( compareTo(number, MIN_LONG) < 0 || compareTo(number, MAX_LONG) > 0 )out.println( s + " can't be fitted anywhere.");
	            else out.println(s+" can be fitted in:");

	            // byte  verify
	            if(compareTo(number, MIN_Byte) >= 0  && compareTo(number, MAX_Byte) <= 0 ) out.println("* byte");

	            // short verify
	            if(compareTo(number, MIN_SHORT) >= 0 && compareTo(number, MAX_SHORT) <= 0 )out.println("* short");

	            // int   verify
	            if(compareTo(number, MIN_INT) >= 0   && compareTo(number, MAX_INT) <= 0 )out.println("* int");

	            // long  verify
	            if(compareTo(number, MIN_LONG) >= 0  && compareTo(number, MAX_LONG) <= 0 )out.println("* long");

	        }
	}
}
