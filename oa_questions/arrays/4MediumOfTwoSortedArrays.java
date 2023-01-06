// hard
// 4MediumOfTwoSortedArrays
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double median = 0;
        int medianIndex = 0;
        if (nums1.length == 0 && nums2.length > 0) {
            median = nums2[nums2.length/2];
        } else if (nums2.length == 0 && nums1.length > 0) {
            median = nums1[nums1.length/2];
        } else if (nums1.length == 0 && nums2.length == 0) {
            return 0;
        }
        
        int totalLength = nums1.length + nums2.length;
        medianIndex = (int) Math.ceil((double)(totalLength + 1)/2);
        int[] ans = new int[medianIndex];
        int iIndex = 0, jIndex = 0;
        for (int i = 0; i < medianIndex; i++) {
            int next = 0;
            if (iIndex < nums1.length && jIndex < nums2.length) {
                next = (nums1[iIndex] < nums2[jIndex])
                ? nums1[iIndex++]
                : nums2[jIndex++];
            } else if (jIndex < nums2.length) {
                next = nums2[jIndex++];
            } else { // One of them has to still be available.
                next = nums1[iIndex++];
            }
            ans[i] = next;
        }
        if (totalLength % 2 == 1) {
            median = ans[medianIndex-1];
        } else{
            median = (double) (ans[medianIndex-2] + ans[medianIndex-1])/2;
        }
    return median;
    }
}