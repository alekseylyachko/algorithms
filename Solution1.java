import java.util.Scanner;
import java.util.Arrays;
import java.util.List;

public class Solution1 {

    static void shift(StringBuffer str) {
            for (int i = 0; i < str.length(); i++) {
                    
                    char c = str.charAt(i);
                    int key = ((int) c)- 1;
                    if (key < 97)
                    key = 123 - (97 - key);
                    c = (char) key;
                
                str.setCharAt(i, c);
            }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
    
        List<String> decoded = Arrays.asList(scanner.nextLine().split(" "));
        int l = decoded.size();
        int n = Integer.parseInt(scanner.nextLine());
        StringBuffer word = new StringBuffer();

        for (int i = 0; i < n; i++) {
            word.replace(0, word.length(), scanner.nextLine());
            while (true) {
                shift(word);
                if (decoded.stream().anyMatch(word.toString()::equals) break;
            };
            System.out.println(word);
        };
    }
}
