class Solution {
    public int trap(int[] height) {
        Deque<Integer> stack = new ArrayDeque<>();
        int ans = 0;
        
        for(int i = 0; i < height.length; i++) {
            int right = height[i];
            while(!stack.isEmpty() && right > height[stack.peek()]) {
                int bottom = height[stack.pop()];
                if (stack.isEmpty()) break;
                
                int left = height[stack.peek()];
                int minHeight = Math.min(left, right);
                int length = i - stack.peek() - 1;
                ans += length * (minHeight - bottom);
            }
            stack.push(i);
        }
        return ans;
    }
}