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

        int i = 0;
        int j = 0;

        while ( (i < match_length) && (j < test_length) ) {

            if (counter > 1) break;

            char m = match_c[i];
            char t = test_c[j];

            if (t != m) {
                counter++;
                if ( (i+1 == match_length) || (j+1 == test_length) ) break;
                if (test_c[j + 1] == m) {
                    j++;
                }
                if (match_c[i + 1] == t) {
                    i++;
                }
            } 
            i++;
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