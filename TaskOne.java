public class TaskOne {

    private static int countMistakes(String match, String test){

        int counter = 0;
        int match_length = match.length();
        int test_length = test.length();

        if ((match_length - test_length) * (match_length - test_length) > 1) {
            return 999;
        }

        char [] match_c = match.toCharArray();
        char [] test_c = test.toCharArray();

        int j = 0;
        for (int i = 0; i < match_length; i++) {

            char m = match_c[i];
            char t = test_c[j];


            if (t != m) {
                if (j + 1 == test_length) {
                    return ++counter;
                }
                if (i + 1 == match_length) {
                    return ++counter;
                }
                if (test_c[j + 1] == match_c[i + 1]) {
                    counter++;
                    j++;
                    continue;
                }
                if ( (test_c[j + 1] == m) || (t == match_c[i+1]) ) {
                    if (test_c[j + 1] == m) {
                        j++;
                    } else {
                        j--;
                    }
                    counter++;
                } else {
                    return counter + 2;
                }
            } else {
                if ( (j + 1 == test_length) && (i + 1 == match_length) ) {
                    continue;
                } else if ( (j + 1 == test_length) || (i + 1 == match_length) ) {
                        return ++counter;
                    }
            }
            
            if (counter >= 2) {
                
                return counter;
            }

            System.out.println(i + " " + j);

            j++;
        }
        

        return counter;
    }

    public static boolean hasMistakes(String match, String test) {

        int res = countMistakes(match, test);

        System.out.println(res);

        if (res == 1) {

            return true;
        } else {
            
            return false;
        }
    }

    public static void main(String[] args) {

        String match = args[0];
        String test = args[1];

        if (hasMistakes(match, test)) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }
}