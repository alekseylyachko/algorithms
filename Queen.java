import java.io.*;
import java.math.*;
import java.security.*;
import java.sql.PseudoColumnUsage;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

import javax.sound.sampled.Line;

public class Queen {

    static void _print(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            if (i == 0) continue;
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    static int[] parse(int n, int[][] obst) {
        int size = n * n + 1;
        int res[] = new int[size];
        if (obst.length == 0) {
            return res;
        }
        for (int i = 0; i < size; i++) {
            res[i] = 0;
        }
        for (int i = 0; i < obst.length; i++) {
            int a = obst[i][0];
            int b = obst[i][1];

            res[(4 - a)*n + b] = -1;
        }
        return res;
    }

    public static int count(int arr[]) {
        int res = 0;
        for (int i = 0; i < arr.length; i++){
            if (arr[i] == 1) res++;
        }
        return res;
    }

    public static int pos(int q, int n) {
        return q % n;
    }

    public static int line(int q, int n) {
        int pos = pos(q,n);
        if (pos == 0) {
            return q / n;
        } else {
            return q / n + 1;
        }
    }


    static int[] horizontal(int n, int q, int[] arr) {
        int pos = pos(q,n);
        int line = line(q,n);

        if (pos != 1) {
            for (int i = q-1; i > n * (line - 1); i--) {
                
                if (arr[i] != -1) {
                    arr[i] = 1;
                } else {
                    break;
                }
            }
        }
        if (pos != 0) {
            for (int i = q+1; i < n * line + 1; i++) {
                if (arr[i] != -1) {
                    arr[i] = 1;
                } else {
                    break;
                }
            }
        }
        return arr;
    }

    public static int[] vertical(int n, int q, int[] arr){
        int pos = pos(q,n);
        int line = line(q,n);

        if (line != 1) {
            for (int i = q-n; i > 0; i -= n) {
                if (arr[i] != -1) {
                    arr[i] = 1;
                } else {
                    break;
                }
            }
        }
        if (line != n) {
            for (int i = q+n; i <= q + n * (n - line); i += n) {
                if (arr[i] != -1) {
                    arr[i] = 1;
                } else {
                    break;
                }
            }
        }
        return arr;
    }

    public static int[] z1(int n, int q, int[] arr){
        int pos = pos(q,n);
        int line = line(q,n);

        int dif = n - 1;


        if (pos != 0) {
            for (int i = q-dif; pos(i+dif,n) != 0 && (line(i+dif, n)) != 1; i -= dif) {
                if (arr[i] != -1) {
                    arr[i] = 1;
                } else {
                    break;
                }
            }
        }
        if (pos != 1) {
            for (int i = q+dif; pos(i-dif,n) != 1 && (line(i-dif, n)) != n; i += dif) {
                if (arr[i] != -1) {
                    arr[i] = 1;
                } else {
                    break;
                }
            }
        }
        return arr;
    }

    public static int[] z2(int n, int q, int[] arr){
        int pos = pos(q,n);
        int line = line(q,n);

        int dif = n + 1;

        if (pos != 0) {
            for (int i = q+dif; pos(i-dif,n) != 0 && (line(i-dif, n)) != n; i += dif) {
                if (arr[i] != -1) {
                    arr[i] = 1;
                } else {
                    break;
                }
            }
        }
        if (pos != 1) {
            for (int i = q-dif; pos(i+dif,n) != 1 && (line(i+dif, n)) != 1; i -= dif) {
                if (arr[i] != -1) {
                    arr[i] = 1;
                } else {
                    break;
                }
            }
        }
        return arr;
    }

    // Complete the queensAttack function below.
    static int queensAttack(int n, int k, int r_q, int c_q, int[][] obstacles) {

        int[] work = parse(n, obstacles);
        
        int queen = (n - c_q)*n + r_q;

        work = horizontal(n, queen, work);
        work = vertical(n, queen, work);
        work = z1(n, queen, work);
        work = z2(n, queen, work);

        return count(work);
    }

    public static void main(String[] args) throws IOException {


        int n = Integer.parseInt(args[0]);
        int k = Integer.parseInt(args[1]);
        int c_q = Integer.parseInt(args[2]);
        int r_q = Integer.parseInt(args[3]);
        int[][] obstacles = new int[k][2];


        if (k != 0) {
            int j = 4;
            for (int i = 0; i < k; i++) {
                obstacles[i][0] = Integer.parseInt(args[j]);
                obstacles[i][1] = Integer.parseInt(args[j+1]);
                j += 2;
            };
        }

        System.out.println("res " + queensAttack(n, k, r_q, c_q, obstacles));
    }
}
