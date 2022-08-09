class Solution {
    public int trap(int[] height) {
        Stack<Integer> stack = new Stack<Integer>();
        int i = 0;
        int ret = 0;
        while(i < height.length) {
            if (stack.isEmpty() || height[i] <= height[stack.peek()]) {
                stack.push(i++);
            } else {
                int middle = stack.pop();
                if (!stack.isEmpty()) {
                    int minHeight = Math.min(height[i], height[stack.peek()]);
                    ret += (minHeight - height[middle]) * (i - stack.peek() - 1);
                }
            }
        }
        return ret;
    }
}