public class 1086HighFive {
        public int[][] highFive(int[][] items) {
            TreeMap<Integer, PriorityQueue<Integer>> treeMap = new TreeMap<>();
            for (int[] studentToScores : items) {
                if (treeMap.containsKey(studentToScores[0])) {
                    PriorityQueue<Integer> maxHeap = treeMap.get(studentToScores[0]);
                    maxHeap.offer(studentToScores[1]);
                    if (maxHeap.size() > 5) {
                        maxHeap.poll();
                    }
                    treeMap.put(studentToScores[0], maxHeap);
                } else {
                    PriorityQueue<Integer> maxHeap = new PriorityQueue<>();
                    maxHeap.offer(studentToScores[1]);
                    treeMap.put(studentToScores[0], maxHeap);
                }
            }
            int size = treeMap.size();
            int outputIndex = 0;
            System.out.println(size);
            int[][] result = new int[size][2];
            for (int id : treeMap.keySet()) {
                
                int sum = 0;
                PriorityQueue<Integer> maxHeap = treeMap.get(id);
                while (!maxHeap.isEmpty()) {
                    sum += maxHeap.poll();
                }
                result[outputIndex][0] = id;
                result[outputIndex][1] = sum / 5;
                outputIndex++;
            }
            return result;
        }
}
