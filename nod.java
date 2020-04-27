import java.io.*;
import java.util.*;


public class nod {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        Integer a = scanner.nextInt();
        Integer b = scanner.nextInt();

        int m = a * b;
        int count = 0;

        for (int i = 1; i < m; i++) {

            for (int k = 1; k < m; k++) {

                if ((i % a == 0) && (k % a == 0) && (b % i == 0) && (b % k == 0) && (b != k)){
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}

