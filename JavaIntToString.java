import java.io.*;
import java.util.*;
// https://www.hackerrank.com/challenges/java-int-to-string/problem?isFullScreen=true
public class JavaIntToString {

    public static void main(String[] args) {
        var reader = new Scanner(System.in);
        var number = reader.next();
        try{
            var n = Integer.parseInt(number);
            var inRange = n <= 100 || n >= -100;
            if(inRange)System.out.println("Good job");
            else System.out.println("Wrong answer");
        }catch(Exception e){
            System.out.println("Wrong answer");
        }
    }
}
