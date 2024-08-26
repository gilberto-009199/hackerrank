package algoritm;

import java.util.Arrays;
import java.util.Scanner;

// https://www.hackerrank.com/challenges/java-string-compare/problem?isFullScreen=true
public class JavaStringCompare {
	 public static String getSmallestAndLargest(String s, int k) {
	        String[] listCombinations = new String[s.length() - (k - 1) ];
	        
	        for(int i = 0; i < listCombinations.length; i++) {
	        	listCombinations[i] = s.substring(i, i+k);	        
	        }
	        
	        Arrays.sort(listCombinations);
	        
	        return listCombinations[0] + "\n" + listCombinations[listCombinations.length-1];
	    }


	    public static void main(String[] args) {
	        Scanner scan = new Scanner(System.in);
	        String s = scan.next();
	        int k = scan.nextInt();
	        scan.close();
	      
	        System.out.println(getSmallestAndLargest(s, k));
	    }
}
