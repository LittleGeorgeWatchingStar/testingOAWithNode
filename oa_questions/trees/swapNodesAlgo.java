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
     * Complete the 'swapNodes' function below.
     *
     * The function is expected to return a 2D_INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. 2D_INTEGER_ARRAY indexes
     *  2. INTEGER_ARRAY queries
     */
     private static class Node {
        Integer data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }

        void swapNodes() {
            Node temp = left;
            left = right;
            right = temp;
        }
    }
    
    static void swapper(Node node, int depth, int target) {
        if (node == null) {
            return;
        }

        if (depth % target == 0) {
            node.swapNodes();
        }

        swapper(node.left, depth + 1, target);
        swapper(node.right, depth + 1, target);
    }

    static List<Integer> traverse(Node node) {
        List<Integer> order = new ArrayList<>();
        innerTraverse(node, order);

        return order;
    }

    static void innerTraverse(Node node, List<Integer> nodeOrder) {
        if (node == null) {
            return;
        }

        innerTraverse(node.left, nodeOrder);
        nodeOrder.add(node.data);
        innerTraverse(node.right, nodeOrder);
    }

    static Node buildTree(List<List<Integer>> indexes) {
        Node root = new Node(1);
        Queue<Node> q = new LinkedList<>();
        q.add(root);

        for (List<Integer> index : indexes) {
            Node left;
            Node right;

            if (index.get(0) != -1) {
                left = new Node(index.get(0));
            } else {
                left = null;
            }

            if (index.get(1) != -1) {
                right = new Node(index.get(1));
            } else {
                right = null;
            }

            Node temp = q.remove();
            temp.left = left;
            temp.right = right;

            if (left != null)
                q.add(left);
            if (right != null)
                q.add(right);
        }

        return root;
    }

    public static List<List<Integer>> swapNodes(List<List<Integer>> indexes, List<Integer> queries) {
        // Write your code here
        Node root = buildTree(indexes);
        List<List<Integer>> traverses = new ArrayList<>();

        for (int query : queries) {
            swapper(root, 1, query);

            List<Integer> path = traverse(root);

            traverses.add(path);
        }

        return traverses;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> indexes = new ArrayList<>();

        IntStream.range(0, n).forEach(i -> {
            try {
                indexes.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int queriesCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> queries = IntStream.range(0, queriesCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .map(String::trim)
            .map(Integer::parseInt)
            .collect(toList());

        List<List<Integer>> result = Result.swapNodes(indexes, queries);

        result.stream()
            .map(
                r -> r.stream()
                    .map(Object::toString)
                    .collect(joining(" "))
            )
            .map(r -> r + "\n")
            .collect(toList())
            .forEach(e -> {
                try {
                    bufferedWriter.write(e);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
