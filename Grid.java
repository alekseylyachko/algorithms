import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Grid {

    static void subarr(String[] arr, int a, int b, int c, int d, String res[]) {
        for (int i = 0; i < res.length; i++) {
            res[i] = arr[i+a].substring(c, d);
        }
    }

    static boolean equals_(String [] a, String [] b) {
        if (a.length != b.length) return false;
        for (int i = 0; i < a.length; i++) {
            if (!a[i].equals(b[i])) return false;
        }
        return true;
    }

    static void print_(String [] a, String [] b) {

        System.out.println("------------1");

        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }

        System.out.println("------------2");

        for (int i = 0; i < b.length; i++) {
            System.out.println(b[i]);
        }

        System.out.println(equals_(a, b));
    }

    // Complete the gridSearch function below.
    static String gridSearch(int R, int C, int r, int c, String[] G, String[] P) {

        int n = (R - r + 1);
        int l = (C - c + 1);

        String [] res = new String[r];

        for (int i = 0; i < n; i++ ) {
            for (int j = 0; j < l; j++) {
                subarr(G, i, i + r, j, j + c,res);
                if (equals_(P,res)) return "YES";
            }
        }
        return "NO";
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        // BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            String[] RC = scanner.nextLine().split(" ");

            int R = Integer.parseInt(RC[0]);

            int C = Integer.parseInt(RC[1]);

            String[] G = new String[R];

            for (int i = 0; i < R; i++) {
                String GItem = scanner.nextLine();
                G[i] = GItem;
            }

            String[] rc = scanner.nextLine().split(" ");

            int r = Integer.parseInt(rc[0]);

            int c = Integer.parseInt(rc[1]);

            String[] P = new String[r];

            for (int i = 0; i < r; i++) {
                String PItem = scanner.nextLine();
                P[i] = PItem;
            }
            
            String result = gridSearch(R, C, r, c, G, P);
            System.out.println(result);

            // bufferedWriter.write(result);
            // bufferedWriter.newLine();
        }

        // bufferedWriter.close();

        scanner.close();
    }
}