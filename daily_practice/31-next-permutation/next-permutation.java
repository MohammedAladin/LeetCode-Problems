 class Solution {

     public void nextPermutation(int[] nums) {
         int lastPos = -1;
         for(int i = nums.length-2; i>=0; --i){
             if(nums[i] < nums[i+1]){
                 lastPos = i;
                 break;
             }
         }

         if(lastPos==-1){
             for(int i = 0; i<nums.length/2; ++i){
                 int temp = nums[i];
                 nums[i] = nums[nums.length-1-i];
                 nums[nums.length-1-i] = temp;
             }
             return;
         }

         int i = lastPos+1;
         int j = nums.length-1;
         while(j>i){
             int temp = nums[i];
             nums[i] = nums[j];
             nums[j] = temp;

             i++;
             j--;
         }
         for(int k = lastPos+1; k<nums.length; ++k){
             if(nums[k]>nums[lastPos]){
                 int temp = nums[k];
                 nums[k] = nums[lastPos];
                 nums[lastPos] = temp;
                 break;
             }
         }

     }
}