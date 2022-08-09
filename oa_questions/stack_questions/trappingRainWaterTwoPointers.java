class Solution {
    public int trap(int[] height) {
        int l=0;
        int r=height.length-1;
        while(l<r && height[l]<height[l+1])
            l++;
        while(l<r && height[r]<height[r-1])
            r--;
        int ans=0;
        
        while(l<r){
            int left=height[l];
            int right=height[r];
         if(left<=right){   
            while(l<r && left>=height[l]){
                ans+=left-height[l];
                l++;
            }}
        else{
            while(l<r && right>=height[r]){
                ans+=right-height[r];
                r--;
            }}
        }
        return ans;
    }
}