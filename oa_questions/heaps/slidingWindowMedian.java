class Solution {
    private PriorityQueue<Integer> left;  // max heap
    private PriorityQueue<Integer> right;  // min heap
    
    public double[] medianSlidingWindow(int[] nums, int k) {
        left = new PriorityQueue<>(k/2+2, (a, b) -> Integer.compare(b, a));
        right = new PriorityQueue<>(k/2+2);
        double[] res = new double[nums.length - k + 1];
        for (int i = 0; i < nums.length; i++) {
            add(nums[i]);
            int j = i - k + 1 ;
            if (j >= 0) {
                res[j] = getMedian();
                remove(nums[j]);
            }
        }
        return res;
    }
    
    private double getMedian() {
        if (left.size() == right.size()) {
            return ((double) left.peek() + right.peek()) / 2.0;
        } else if (left.size() > right.size()) {
            return left.peek();
        } else {
            return right.peek();
        }
    }
    
    private void add(int num) {
        if (left.isEmpty() || left.peek() >= num) {
            left.add(num);
        } else {
            right.add(num);
        }
        rebalance();
    }
    
    private void remove(int num) {
        if (num <= left.peek()) {
            left.remove(num);
        } else {
            right.remove(num);
        }
        rebalance();
    }
    
    private void rebalance() {
        if (left.size() > right.size() + 1) {
            right.add(left.poll());
        } else if (left.size() < right.size()) {
            left.add(right.poll());
        }
    }
}