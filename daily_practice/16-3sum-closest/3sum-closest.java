 class Solution {

    // -5 -1 1 2 3 8

     public int threeSumClosest(int[] nums, int target) {
         Arrays.sort(nums);

         int min = 100000;
         int ans=0;
         for(int i = 0; i<nums.length; ++i){

             int l = i+1;
             int r = nums.length-1;
             while(r>l){
                 int sum = nums[i] + nums[l] + nums[r];
                 int abs = Math.abs(sum-target);
                 if(min>abs) {
                     min = abs;
                     ans = sum;
                 }

                if(sum>target)r--;
                else if(sum<target)l++;
                else return sum;

             }
         }
         return ans;
     }
}