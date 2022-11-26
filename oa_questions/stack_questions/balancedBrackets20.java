import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'isBalanced' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String isBalanced(String s) {
        // Write your code here
        if(s == null || s.length() % 2 != 0) return "NO";
        Stack<Character> stack = new Stack<Character>();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == '(' || c == '{' || c == '['){
                stack.push(c);
            } else if(c == ')' || c == '}' || c == ']'){
                if(!stack.isEmpty()){
                    char latestOpenP = stack.pop();
                    if(latestOpenP == '(' && c != ')'){
                        return "NO";
                    } else if(latestOpenP == '{' && c != '}'){
                        return "NO";
                    } else if(latestOpenP == '[' && c != ']'){
                        return "NO";
                    }
                } else {
                    return "NO";
                }
            }
        }
    
        return stack.isEmpty() ? "YES" : "NO";
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                String s = bufferedReader.readLine();

                String result = Result.isBalanced(s);

                bufferedWriter.write(result);
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }


    // second solution

    public boolean isValid(String s) {
        Stack<Character> pair = new Stack<>();

        int n = s.length();
        if (n=0) return true;

        for (int i =0; i <n; i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') {
                pair.push(s.charAt(i));
            } else if (s.charAt(i) == ')') {
                if (pair.isEmpty() || pair.pop != '(') return false;
            } else if (s.charAt(i) == ']') {
                if (pair.isEmpty() || pair.pop != '[') return false;
            } else if (s.charAt(i) == '}') {
                if (pair.isEmpty() || pair.pop != '{') return false;
            }
        }

        return pair.isEmpty();
    }
}
