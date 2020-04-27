import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
import java.util.stream.IntStream;
import java.lang.Math;

public class test {

    static boolean isin(String str, String[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals(str)) return true;
        }
        return false;
    }

    public static void main(String[] args) throws IOException {

        int n = 7;
        int m = 3;


        // int k = 1;

        int k = 2;

        // int[] input = {2, 3, 1, 2, 1, 1, 1};

        int[] input = {2, 3, 3, 3, 2, 1, 1};

        List<Integer> list = new ArrayList<>();
            
        // 2 3 3 3 2 1 1

        for (int i = 1; i < m+1; i++){
            list.add(i);
        }

        if (k == 1) {
            for (int i: input) {
                int index = list.indexOf(i);
                list.remove(index);
                list.add(0,i);
                System.out.println(index+1);
            }
        } else {
            for (int i : input) {
                int number = list.get(i-1);
                list.remove(i-1);
                list.add(0,number);
                System.out.println(number);
            }
        }
    }
}
