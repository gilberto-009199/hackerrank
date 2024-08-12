package algoritm;

import java.io.*;
import java.util.*;

// https://www.hackerrank.com/challenges/java-end-of-file/problem?isFullScreen=true
public class JavaEndOfFile {
	public static void main(String[] args) throws IOException {
		Scanner reader = new Scanner(System.in);
        int count = 1;
        StringBuilder buff = new StringBuilder();
        while(reader.hasNext()){
            buff.append(count+" "+reader.nextLine()+"\n");
            count++;
        }
        System.out.print(buff.toString());
	}
}
