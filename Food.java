import java.io.*;
import java.math.*;
import java.security.*;
import java.sql.PseudoColumnUsage;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;


public class Food {

    private static final Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) throws IOException {

        Map<String, Double> ingridients = new HashMap<String, Double>();
        Map<String, Integer> dishes = new HashMap<String, Integer>();
        Map<String, Integer> res = new HashMap<String, Integer>();

        int n = Integer.parseInt(scanner.nextLine());

        for(int i = 0; i < n; i++) {
            List<String> d = Arrays.asList(scanner.nextLine().split(" "));
            dishes.putIfAbsent(d.get(0), Integer.parseInt(d.get(1)));
            Integer wannabes = Integer.parseInt(d.get(1));

            for (int j = 0; j < Integer.parseInt(d.get(2)); j++) {
                List<String> ing = Arrays.asList(scanner.nextLine().split(" "));

                String name = ing.get(0);
                Double value = Double.parseDouble(ing.get(1));
                String var = ing.get(2);

                if (var.equals("g")) {
                    value = value / 1000;
                } else if (var.equals("ml")) {
                    value = value / 1000;
                } else if (var.equals("cnt")) {
                    value = value / 10;
                }

                if (ingridients.containsKey(name)) {
                    ingridients.replace(name,  ingridients.get(name) + wannabes * value);
                } else {
                    ingridients.put(name,  wannabes * value);
                }
            }
        }

        int k = Integer.parseInt(scanner.nextLine());
        int total = 0;

        for(int i = 0; i < k; i++) {
            List<String> d = Arrays.asList(scanner.nextLine().split(" "));

            String name = d.get(0);
            
            if (!ingridients.containsKey(name)) continue;

            Integer price = Integer.parseInt(d.get(1));
            Double value = Double.parseDouble(d.get(2));
            String var = d.get(3);

            if (var.equals("g")) {
                value = value / 1000;
            } else if (var.equals("ml")) {
                value = value / 1000;
            } else if (var.equals("cnt")) {
                value = value / 10;
            }

            Double newval =  Math.ceil(ingridients.get(name) / value);
            res.put(name, newval.intValue());
            
            total += newval * price;
        }

        System.out.println(total);
        res.forEach((key, val) -> {System.out.println(key + " " + val.intValue());});

        // int m = Integer.parseInt(scanner.nextLine());

        // for(int i = 0; i < m; i++) {

        // }

        // System.out.println("res " + queensAttack(n, k, r_q, c_q, obstacles));
    }
}


// 2
// sandwich 7 3
// butter 10 g
// toasted_bread 2 cnt
// sausage 30 g
// omelet 9 4
// egg 4 cnt
// milk 120 ml
// salt 1 g
// sausage 50 g
// 7
// egg 61 1 tens
// milk 58 1 l
// sausage 100 480 g
// butter 120 180 g
// cream 100 350 g
// salt 14 1000 g
// toasted_bread 40 20 cnt
