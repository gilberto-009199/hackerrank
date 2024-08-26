package algoritm;

import java.io.*;
import java.util.*;

// https://www.hackerrank.com/challenges/java-strings-introduction/problem?isFullScreen=true
public class JavaStringsCompare {
	public static void main(String[] args) {
		Scanner sc	=	new Scanner(System.in);
        String	A	=	sc.next();
        String 	B	=	sc.next();
        
        // 1. Sum the lengths of A and B
        int lengthSum = A.length() + B.length();
        System.out.println(lengthSum);

        // 2. Lexicographical comparison
        if (A.compareTo(B) > 0) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }

        // 3. Capitalize the first letter of both A and B, and print them
        String capitalizedA = A.substring(0, 1).toUpperCase() + A.substring(1);
        String capitalizedB = B.substring(0, 1).toUpperCase() + B.substring(1);
        System.out.println(capitalizedA + " " + capitalizedB);
	}
}
