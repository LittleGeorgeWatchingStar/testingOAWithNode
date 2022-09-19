import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'getMax' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts STRING_ARRAY operations as parameter.
     */

    public static List<Integer> getMax(List<String> operations) {
    // Write your code here
        Stack<Integer> stack=new Stack<>();
        Stack<Integer> max=new Stack<>();
        List<Integer> list=new ArrayList<>();
        // System.out.println(operations.size());
        for(int i=0;i<operations.size();i++)
        {
            String type[]=(operations.get(i)).split(" ");
            switch(type[0])
            {
                case "1":
                int k=Integer.parseInt(type[1]);
                stack.push(k);
                if(max.isEmpty() || k>=max.peek())
                {
                    max.push(k);
                }
                break;
            case "2":
                k=stack.pop();
            
                if(k==max.peek())
                {
                    max.pop();
                }
                break;
            case "3":
                list.add(max.peek());
                break;          
         
        }
    }
    return list; 
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> ops = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String opsItem = bufferedReader.readLine();
            ops.add(opsItem);
        }

        List<Integer> res = Result.getMax(ops);

        for (int i = 0; i < res.size(); i++) {
            bufferedWriter.write(String.valueOf(res.get(i)));

            if (i != res.size() - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
